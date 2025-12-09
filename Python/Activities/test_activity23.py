import pytest

"""@pytest.fixture
def list():

    num = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    return num"""

def test_sum(list):
    sum = 0
    for n in list:
        sum += n
    assert sum == 55