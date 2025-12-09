"""import pytest

@pytest.fixture 
def sample_list():
    return [1,2,3]

@pytest.fixture 
def resource():
    conn = open("file.txt","w")
    yield conn
    conn.close()"""

import pytest

@pytest.fixture
def list():

    num = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    return num