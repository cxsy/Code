import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.*;

class Solution {
    ConcurrentMap<String, Boolean> totalUrls = new ConcurrentHashMap<>();

    LinkedList<String> urlsToCrawl = new LinkedList<>();
    ReentrantLock requestLock = new ReentrantLock();

    LinkedList<String> resultUrls = new LinkedList<>();
    ReentrantLock resultLock = new ReentrantLock();

    AtomicInteger runnning = new AtomicInteger(0);

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        totalUrls.put(startUrl, true);
        addToResultUrls(startUrl);
        addToUrlsToCrawl(startUrl);
        String hostname = extractHostname(startUrl);
        while (true) {
            String urlToCrawl = fetchUrlToCrawl();
            if (urlToCrawl == null) {
                if (runnning.get() == 0)
                    break;
                LockSupport.parkNanos(1L);
            } else {
                inc();
                new Thread(new Helper(this, hostname, htmlParser, urlToCrawl)).start();
            }
        }
        return resultUrls;
    }

    String extractHostname(String url) {
        url = url.substring(7);
        int i = url.indexOf('/');
        return i == -1 ? url : url.substring(0, i);
    }

    class Helper implements Runnable {
        Solution solution;
        String hostname;
        HtmlParser htmlParser;
        String urlToCrawl;

        Helper(Solution solution, String hostname, HtmlParser htmlParser, String urlToCrawl) {
            this.solution = solution;
            this.hostname = hostname;
            this.htmlParser = htmlParser;
            this.urlToCrawl = urlToCrawl;
        }

        void filterUrls(List<String> crawlUrls) {
            if (crawlUrls == null)
                return;
            for (String url : crawlUrls) {
                if (solution.totalUrls.containsKey(url))
                    continue;
                solution.totalUrls.put(url, true);
                if (!extractHostname(url).equals(hostname))
                    continue;
                solution.addToResultUrls(url);
                solution.addToUrlsToCrawl(url);
            }
        }

        @Override
        public void run() {
            try {
                filterUrls(htmlParser.getUrls(urlToCrawl));
            } finally {
                this.solution.desc();
            }
        }
    }

    String fetchUrlToCrawl() {
        requestLock.lock();
        try {
            return urlsToCrawl.poll();
        } finally {
            requestLock.unlock();
        }
    }

    void addToUrlsToCrawl(String url) {
        requestLock.lock();
        try {
            urlsToCrawl.add(url);
        } finally {
            requestLock.unlock();
        }
    }

    void addToResultUrls(String url) {
        resultLock.lock();
        try {
            resultUrls.add(url);
        } finally {
            resultLock.unlock();
        }
    }

    void inc() {
        runnning.getAndIncrement();
    }

    void desc() {
        runnning.getAndDecrement();
    }
}