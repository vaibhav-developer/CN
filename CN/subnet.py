def calculate_subnet_masks(ip_address, subnet_bits):
    # Convert the IP address to binary format
    ip_octets = [bin(int(octet))[2:].zfill(8)
                 for octet in ip_address.split('.')]
    binary_ip = ''.join(ip_octets)

    # Calculate the subnet mask
    subnet_mask = '1' * subnet_bits + '0' * (32 - subnet_bits)

    # Divide the subnet mask into octets
    subnet_mask_octets = [str(int(subnet_mask[i:i + 8], 2))
                          for i in range(0, 32, 8)]
    subnet_mask_string = '.'.join(subnet_mask_octets)

    return subnet_mask_string


if __name__ == '__main__':
    # Input IP address and subnet bits
    ip_address_input = input("Enter the IP address (e.g., 192.168.1.0): ")
    subnet_bits_input = int(input("Enter the number of subnet bits: "))

    subnet_mask_result = calculate_subnet_masks(
        ip_address_input, subnet_bits_input)
    print(f"IP Address: {ip_address_input}")
    print(f"Subnet Bits: {subnet_bits_input}")
    print(f"Subnet Mask: {subnet_mask_result}")
