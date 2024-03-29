# Binary 
binary_data = "01000011010101000100011001111011010000100110100101110100010111110100011001101100011010010111000001110000011010010110111001111101"

# this is going to spit the binary into bits of 8
binary_chunks = [binary_data[i:i+8] for i in range(0, len(binary_data), 8)]

# Convert binary chunks to ASCII characters
text_data = ''.join([chr(int(chunk, 2)) for chunk in binary_chunks])

print(text_data)

#printing text will display the text after converting it to ASCII
