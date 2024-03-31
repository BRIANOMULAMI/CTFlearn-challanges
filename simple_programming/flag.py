def count_lines(file_name):
    with open(file_name, 'r') as file:
        lines = file.readlines()

    count = 0
    for line in lines:
        zeros = line.count('0')
        ones = line.count('1')
        if zeros % 3 == 0 or ones % 2 == 0:
            count += 1

    return count

if __name__ == "__main__":
    file_name = input("Enter the file name: ")
    lines_count = count_lines(file_name)
    print(f"Number of lines where the count of 0's is a multiple of 3 or the count of 1's is a multiple of 2: {lines_count}")
