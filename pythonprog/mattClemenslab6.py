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

def fullname(fname, lname):
    """
    Given a first name and a last name, return the full name 
    in the format "lastname, firstname".
    >>> fullname("Michael", "Jackson")
    'Jackson, Michael'
    >>> fullname("Matt", "Clemens")
    'Clemens, Matt'
    >>> fullname("James", "Bond")
    'Bond, James'
    """
    return lname+", " +fname

def shifter( n, k):
    """
    Given two numbers n and k return the rsult of the mapping function (n+k) mod 26
    >>> shifter(12,15)
    1
    >>> shifter(18,13)
    5
    >>> shifter(24,10)
    8
    """
    return (n+k)%26

def encode(str):
    """ Given a string of uppercase letters, return a list of numbers using
    the mapping A->0, B>1, ....
    >>> encode('ABC')
    [0, 1, 2]
    >>> encode('SIERRA')
    [18, 8, 4, 17, 17, 0]
    >>> encode('MATTHEW')
    [12, 0, 19, 19, 7, 4, 22]
    """
    return[ord(c)-65 for c in list(str)]

def decode(num):
    """
    Given a list of numbers where A=0, B=1, .... return the corresponding string

    >>> decode([0, 1, 2])
    'ABC'
    >>> decode([18, 8, 4, 17, 17, 0])
    'SIERRA'
    >>> decode([12, 0, 19, 19, 7, 4, 22])
    'MATTHEW'
    """
    return "".join(chr(n+65) for n in num)

def shiftcipher(str, k):
    """
    Given a string and k, return the shifter string
    >>> shiftcipher('SIERRA', 15)
    'HXTGGP'
    >>> shiftcipher("MATTHEW", 10)
    'WKDDROG'

    """
    return decode([shifter(x,k) for x in encode(str)])

def linear(m, a, k):
    """
    Given three numbers use them in the formula (m*a+k) mod 26
    >>> linear(4,7,12)
    14
    >>> linear(30,8,11)
    17
    """
    return (m*a+k)%26

def linearcipher(str, m, k):
    """
    Given a string encode it using the coefficients m and k
    >>> linearcipher('matthew', 7, 11)
    'HBEEYDZ'
    >>> linearcipher("abcdefghijklmnop", 7, 11)
    'BIPWDKRYFMTAHOVC'
    """
    a=encode(str)
    return decode([linear(m,letters,k)for letters in a])

if __name__== "__main__":
    import doctest
    doctest.testmod(verbose=True, optionflags=doctest.NORMALIZE_WHITESPACE)
