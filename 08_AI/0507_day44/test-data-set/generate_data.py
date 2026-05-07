
import csv
import random
from faker import Faker

# Initialize Faker for US locale
fake = Faker('en_US')

def generate_user_data():
    name = fake.name()
    age = random.randint(18, 90)
    gender = random.choice(['Male', 'Female'])
    
    # Faker's address can be multi-line. Split by newline and join with comma.
    # Ensure the newline character is properly escaped for the split method.
    address_parts = fake.address().split(chr(10)) # Using ASCII for newline character
    formatted_address = ', '.join(part.strip() for part in address_parts if part.strip())
    
    return [name, age, gender, formatted_address]

# Generate 100 entries
data = [generate_user_data() for _ in range(100)]

# Write to CSV file
file_path = 'user_data.csv'
with open(file_path, 'w', newline='', encoding='utf-8') as csvfile:
    writer = csv.writer(csvfile)
    writer.writerow(['Full Name', 'Age', 'Gender', 'US Address'])  # Write header
    writer.writerows(data)

print(f"Successfully generated {file_path} with 100 entries.")
