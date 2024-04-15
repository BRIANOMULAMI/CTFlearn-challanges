from Crypto.Util.number import inverse, long_to_bytes

# Given values
a = 416064700201658306196320137931
b = 590872612825179551336102196593
n = 245841236512478852752909734912575581815967630033049838269083
ct = 219878849218803628752496734037301843801487889344508611639028
e = 3

# Calculate phi(n)
puy = (a - 1) * (b - 1)

# Calculate private key exponent d
d = inverse(e, puy)

# Decrypt the ciphertext
flag = pow(ct, d, n)

# Convert the decrypted plaintext to bytes and print
print(long_to_bytes(flag))
