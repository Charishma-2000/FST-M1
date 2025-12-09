import pytest

def test_sum(sample_list):
    assert sum(sample_list) == 6

def test_writing_to_file(resource):
    resource.write("Hello,World!!")
    