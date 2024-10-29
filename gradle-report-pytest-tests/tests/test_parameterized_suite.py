import pytest


@pytest.mark.parametrize("a,b,c", [
    (1, 2, 3),
    (1, 2, 1),
])
def test_parameterized(a, b, c):
    assert a + b == c
