#%%
import matplotlib.pyplot as plt
import numpy as np

a = 3
r = 3**0.5 * a
pi = np.pi
t1 = np.linspace(0, 3**(-0.5) * a * pi, 100)
x1 = t1 + a * np.sin(pi / 6 - t1 / r)
y1 = r - a * np.cos(pi / 6 - t1 / r)

plt.plot(x1, y1, label='T1')
t2 = np.linspace(pi / 3, 2 * pi / 3, 100)
x2 = 3**(-0.5) * a * pi - a * np.cos(t2)
y2 = a * np.sin(t2)

plt.plot(x2, y2, label='T2')
plt.legend()

plt.show()
# %%
import matplotlib.pyplot as plt
import numpy as np
a = 3
t = np.linspace(0, 2 * np.pi, 100)
x = a * np.sin(t)
y = a * np.cos(t)
plt.gca().set_aspect('equal')
plt.plot(x, y)
plt.show()

# %%
import matplotlib.pyplot as plt
import numpy as np
fig = plt.figure()
fig.suptitle('No axes on this figure')
fig, ax_lst = plt.subplots(2, 3)
#%%
import matplotlib.pyplot as plt
# plot() is a versatile command, and will take an arbitrary number
# of arguments.
plt.plot([1, 2, 3, 4])
# If you provide a single list or array to the plot() command,
# matplotlib assumes it is a sequence of y values, and automatically
# generates the x values for you. Since python ranges start with 0,
# the default x vector has the same length as y but starts with 0.
# Hence the x data are [0,1,2,3].
plt.ylabel('some numbers')
plt.show()
#%%
import matplotlib.pyplot as plt
plt.plot([1, 2, 3, 4], [1, 4, 9, 16])
plt.axis([0, 6, 0, 20])
plt.show()
#%%
import matplotlib.pyplot as plt
plt.plot([1, 2, 3, 4], [1, 4, 9, 16], 'ro')
plt.axis([0, 6, 0, 20])
plt.show()
#%%
import matplotlib.pyplot as plt
import numpy as np
t = np.arange(0., 5., 0.2)
plt.plot(t, t, 'r--', t, t**2, 'bs', t, t**3, 'g^')
plt.show()
#%%
import matplotlib.pyplot as plt
import numpy as np
data = {
    'a': np.arange(50),
    'c': np.random.randint(0, 50, 50),
    'd': np.random.randn(50)
}
data['b'] = data['a'] + 10 * np.random.randn(50)
data['d'] = np.abs(data['d']) * 100
# 散点图：x, y, c=color, s=size
plt.scatter('a', 'b', c='c', s='d', data=data)

plt.xlabel('entry a')
plt.ylabel('entry b')
plt.show()
#%%
import matplotlib.pyplot as plt
import numpy as np
names = ['group_a', 'group_b', 'group_c']
values = [1, 10, 100]

plt.figure(figsize=(9, 3))

plt.subplot(131)
plt.bar(names, values)
plt.subplot(132)
plt.scatter(names, values)
plt.subplot(133)
lines = plt.plot(names, values)
plt.setp(lines, color='r', linewidth=2.0)
plt.suptitle('Categorical Plotting')
plt.show()
#%%
import matplotlib.pyplot as plt
import numpy as np

f = lambda t: np.exp(-t) * np.cos(2 * np.pi * t)
t1 = np.arange(0.0, 5.0, 0.1)
t2 = np.arange(0.0, 5.0, 0.02)
plt.figure()
plt.subplot(211)
plt.plot(t1, f(t1), 'bo', t2, f(t2), 'k')
plt.subplot(212)
plt.plot(t2, np.cos(2 * np.pi * t2), 'r--')
plt.show()
#%%
import matplotlib.pyplot as plt
import numpy as np
plt.figure(1)
plt.subplot(211)
plt.plot([1, 2, 3])
plt.subplot(212)
plt.plot([4, 5, 6])
# 创建figure 2
# creates a subplot(111) by default
plt.figure(2)
plt.plot([4, 5, 6])
# 切换至figure 1
plt.figure(1)
plt.subplot(211)
plt.title('Easy as 1, 2, 3')
#%%
import matplotlib.pyplot as plt
import numpy as np
mu, sigma = 100, 15
x = mu + sigma * np.random.randn(10000)
n, bins, patches = plt.hist(x, 50, density=True, facecolor='g', alpha=0.75)
plt.xlabel('Smarts')
plt.ylabel('Probability')
plt.title('Histogram of IQ')
plt.text(60, .025, r'$\mu=100,\ \sigma=15$')
plt.axis([40, 160, 0, 0.03])
plt.grid(True)
plt.show()
#%%
import matplotlib.pyplot as plt
import numpy as np
ax = plt.subplot(111)
t = np.arange(0.0, 5.0, 0.01)
s = np.cos(2 * np.pi * t)
line, = plt.plot(t, s, lw=2)
plt.annotate('local max',
             xy=(2, 1),
             xytext=(3, 1.5),
             arrowprops=dict(facecolor='black', shrink=0.05))
plt.ylim(-2, 2)
plt.show()
#%%
import matplotlib.pyplot as plt
import numpy as np
plt.plot([1, 10, 100], [0, 1, 2])
# 可以设置basey作为对数的底
plt.yscale('log')
plt.title('log')
plt.grid(True)
plt.show()
#%%
import numpy as np
import matplotlib.pyplot as plt


def koch_snowflake(order, scale=10):
    """
    Return two lists x, y of point coordinates of the Koch snowflake.

    Arguments
    ---------
    order : int
        The recursion depth.
    scale : float
        The extent of the snowflake (edge length of the base triangle).
    """
    def _koch_snowflake_complex(order):
        if order == 0:
            # initial triangle
            angles = np.array([0, 120, 240]) + 90
            return scale / np.sqrt(3) * np.exp(np.deg2rad(angles) * 1j)
        else:
            ZR = 0.5 - 0.5j * np.sqrt(3) / 3

            p1 = _koch_snowflake_complex(order - 1)  # start points
            p2 = np.roll(p1, shift=-1)  # end points
            dp = p2 - p1  # connection vectors

            new_points = np.empty(len(p1) * 4, dtype=np.complex128)
            new_points[::4] = p1
            new_points[1::4] = p1 + dp / 3
            new_points[2::4] = p1 + dp * ZR
            new_points[3::4] = p1 + dp / 3 * 2
            return new_points

    points = _koch_snowflake_complex(order)
    x, y = points.real, points.imag
    return x, y


x, y = koch_snowflake(order=5)

plt.figure(figsize=(8, 8))
plt.axis('equal')
plt.fill(x, y)
plt.show()
#%%
import numpy as np
import matplotlib.pyplot as plt
p1 = np.array([1, 2, 3])
p2 = np.roll(p1, shift=-1)
print(p2)