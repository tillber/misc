defmodule MergeSort do
  def start do
    # Unsorted list
    list = [28, 3, 48, 39, 34, 57, 46, 61, 20, 49, 16, 27, 6, 95, 43, 37, 85, 40, 67, 81, 41, 92, 32]

    IO.puts("Unsorted list: " <> str_list(list))
    IO.puts("Starting merge sort...")

    # Perform merge sort on list
    sorted_list = sort(list)

    IO.puts("Finished sorting!")
    IO.puts("Sorted list: " <> str_list(sorted_list))
  end

  def str_list(list) do Enum.join(list, ", ") end

  def sort([]) do [] end
  def sort([e]) do [e] end
  def sort(list) do
    # Split list
    {l, r} = split(list)

    # Sort lists
    l_sorted = sort(l)
    r_sorted = sort(r)

    # Merge sorted lists
    merge(l_sorted, r_sorted)
  end

  def merge([], r) do r end
  def merge(l, []) do l end
  def merge([h1 | t1], [h2 | _] = l2) when h1 < h2 do
    [h1 | merge(t1, l2)]
  end
  def merge(l1,[h2|t2]) do
    [h2|merge(l1,t2)]
  end

  def split(list) do
    split_index = round(length(list) / 2)
    Enum.split(list, split_index)
  end
end
