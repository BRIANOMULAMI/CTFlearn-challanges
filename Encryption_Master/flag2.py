def decode_hex_file(filename):
    try:
        # Open the file for reading
        with open(filename, 'r') as file:
            # Read the hexadecimal-encoded data from the file
            hex_string = file.read().strip()
            
            # Decode the hexadecimal string to bytes
            decoded_bytes = bytes.fromhex(hex_string)
            
            # Convert bytes to string
            decoded_string = decoded_bytes.decode('utf-8')
            
            # Print the decoded string
            print("Decoded text:")
            print(decoded_string)
    except FileNotFoundError:
        print("File not found. Please make sure the file exists and try again.")
    except Exception as e:
        print("An error occurred:", e)

def main():
    # Prompt user to enter the file name
    filename = input("Enter the file name containing the hexadecimal-encoded data: ")
    
    # Decode the hexadecimal-encoded data from the file
    decode_hex_file(filename)

if __name__ == "__main__":
    main()
