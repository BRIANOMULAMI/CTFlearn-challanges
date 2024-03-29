import cv2
from pyzbar.pyzbar import decode

def decode_qr_code(image_path):
    # Read the image
    image = cv2.imread(image_path)

    # Decode QR code
    decoded_objects = decode(image)

    # Print the decoded data
    for obj in decoded_objects:
        print('Type:', obj.type)
        print('Data:', obj.data.decode('utf-8'))
        print()

if __name__ == "__main__":
    image_path = "/home/brian/Downloads/my docs/CTF/ctflearn/qrcode_inspector/inception.png"  # Replace this with the path to your image
    decode_qr_code(image_path)
