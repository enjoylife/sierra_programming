#!~/.local/bin/python3
def quad(x):
    """Given a number, return it raised to the 4th power.
    >>> quad(2)
    16
    >>> quad(4)
    256
    >>> quad(-4)
    256
    """

    return x**4


def triarea(base,height):
    """
    given the base and height of a triangle, return its area.

    >>> triarea(10, 10)
    50.0
    >>> triarea(5, 3)
    7.5
    >>> triarea(-5, 2)
    -5.0
    >>> triarea(4, -3)
    -6.0
    """
    return base*height/2.0
if __name__== "__main__":
    import doctest
    doctest.testmod(verbose=True, optionflags=doctest.NORMALIZE_WHITESPACE)
