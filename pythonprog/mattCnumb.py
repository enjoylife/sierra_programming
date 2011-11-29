def firstn(g,n):
    for i in xrange(n):
        yield g.next()

def intsfrom(i):
    while 1:
        yield i
        i = i +1

def exclude_mults(n, ints):
    for i in ints:
        
        if (i% n):
            yield i

def sieve(ints):
    while 1:
        prime = ints.next()
        yield prime
        ints = exclude_mults(prime, ints)

if __name__=='__main__':
    for i in firstn(sieve(intsfrom(2)), 400):
        print i
