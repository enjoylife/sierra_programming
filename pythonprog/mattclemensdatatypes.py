def gcd(a, b):
    """
    Given  two number return their  Greatest common divisor

    >>> gcd(42, 35)
    7
    >>> gcd(612, 1275)
    51
    """
    if (b == 0):
        return a
    else:
        return gcd(b, a%b)

def lcm(a,b):
    """
    Given 2 numbers  return lowest common multiple of them
    >>> lcm(75,21)
    525
    >>> lcm(52, 81)
    4212
    """
    return a*b // gcd(a,b)

def egcd(a,b):
    """
    >>> egcd (1124,84)
    [8, -107, 4]
    """
    if b ==0:
        return [1,0,a]
    else:
        x,y,d = egcd(b, a%b)
        return [y, x-(a//b)*y,d]
def modinv(a,b):
    """
    >>> modinv(1234, 233)
    None
    """
    g, x, y = egcd(a,b)
    if y !=1:
        return None
    else:
        return x%b

if __name__ == "__main__":
    import doctest
    doctest.testmod(verbose=True, optionflags=doctest.NORMALIZE_WHITESPACE)
