linear-structures
=================

Partial implementations of some linear structures, intended for use
in Grinnell's CSC 207 (and, perhaps, elsewhere).

### @author Samuel A. Rebelsky
### @author Shibam Mukhopadhyay

Exercise 5:
The implementations of put, get, peek, isEmpty made sense and were the same as how I would code it. But I am confused about isFull. I thought about isFull as when the capacity of the stack was the same as the size. But in this case, we get isFull return as false.

Exercise 6:
The implementations of peek, isEmpty, isFull were the same as what I would code it. For Get, I just got the node for the front value and then made the node front was pointing to as the new front of the queue. the put method also was not too difficult, since I figured out the cases for it. Either the back is null for which case we need to have both pointers pointing to the first node. If the back is not null then we just make sure the previous back node points to this node and then call this as the back node.