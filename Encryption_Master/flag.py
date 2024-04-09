import base64

def decode_base64_multiple_layers(encoded_data):
    decoded_data = encoded_data
    try:
        while True:
            decoded_data = base64.b64decode(decoded_data)
            decoded_data = decoded_data.decode('utf-8')
    except:
        pass
    return decoded_data

def main():
    file_name = input("Enter the file name containing the encoded data: ")
    try:
        with open(file_name, 'r') as file:
            encoded_text = file.read()
            decoded_text = decode_base64_multiple_layers(encoded_text)
            print("Decoded text:", decoded_text)
    except FileNotFoundError:
        print("File not found.")

if __name__ == "__main__":
    main()
