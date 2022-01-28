import random
import uuid
import string

PUBLISHER = ["Paralela", "Editura45", "Libertatea", "Libertatea2", "Paralela45", "Editura70", "ZonaIT", "ZonaIT2"]
GENRE = ["Basm", "Nuvela", "Roman", "Comedie", "Poezie"]


def generate_insert_book():
    insert_str = "INSERT INTO pos.book(ISBN,TITLE,PUBLISHER,YEAR,GENRE,STOCK,PRICE) VALUES("
    insert_str += '"' + str(uuid.uuid4()) + '","'

    # isbn
    ran = ''.join(random.choice(string.ascii_uppercase + string.digits) for _ in range(10))
    insert_str += ran + '","'

    # publisher
    insert_str += PUBLISHER[random.randrange(len(PUBLISHER))] + '","'

    # year
    insert_str += str(random.randrange(1900, 2021)) + '","'

    # genre
    insert_str += GENRE[random.randrange(len(GENRE))] + '","'

    # stock
    insert_str += str(random.randrange(1, 10000)) + '","'

    # price
    insert_str += str(random.randrange(10, 200)) + '");'

    return insert_str


if __name__ == "__main__":
    f = open("insert.txt", "w")

    for x in range(100):
        f.write(generate_insert_book())
        f.write("\n")
