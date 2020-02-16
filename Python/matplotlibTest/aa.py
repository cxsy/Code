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
