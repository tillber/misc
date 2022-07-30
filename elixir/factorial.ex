defmodule Factorial do
  def start do
    nums = [9, 3, 6]
    for num <- nums do
      IO.puts("#{num}! is #{factorial(num)}")
    end
  end

  def factorial(0), do: 1 # Factorial of 0 equals 1.
  def factorial(num) do
    num * factorial(num - 1)
  end
end
