import pytest
import math

def test_sum():
   num = 2
   assert num+num == 4

def test_difference():
   num1 = 7
   num2 = 3
   assert num1-num2 == 4

@pytest.mark.activity
def test_product():
   num1=3 
   num2= 4
   assert num1*num2 == 12

@pytest.mark.activity
def test_quotient():
   num1=20
   num2=5
   assert num1/num2 == 4
