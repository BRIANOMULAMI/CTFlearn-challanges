# binary_to_ascii.py

# Define a function to convert binary string to ASCII string
def binary_to_ascii(binary_string):
    # Convert binary string to ASCII characters directly
    ascii_string = ''.join([            # Join the list of characters into a string
        chr(int(binary_string[i:i+8], 2))  # Convert each 8-bit chunk of binary to an ASCII character
        for i in range(0, len(binary_string), 8)  # Iterate over the binary string in steps of 8
    ])
    return ascii_string  # Return the resulting ASCII string

# Read binary data from file
file_path = "brian.txt"  # File path containing binary data
with open(file_path, "r") as file:  # Open file for reading
    # Read the content of the file, remove spaces, and strip leading/trailing whitespace
    binary_data = file.read().replace(" ", "").strip()

# Convert binary to ASCII using the defined function
ascii_data = binary_to_ascii(binary_data)

# Print the resulting ASCII string
print(ascii_data)
