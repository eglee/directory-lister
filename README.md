directory-lister
================

Traverses a directory hierarchy depth first, and outputs a preorder traversal using self implemented stacks, queues, and linked lists.

The Queue and Stack classes are both implemented using the LinkedList class.

To test, copy the folder L0 to your root folder and run the DirectoryListerDriver.  In the DirecortoryListerDriver the default root directory is C, but change it to whatever drive you need.

The test data directory and file hierarchy looks like this:

      C:.
      +---L0
         |   G
         |   text.txt
         |   
         \---L1
            |   E
            |   F
            |   
            +---L2a
            \---L2b
               +---L3a
               |       A
               |       
               \---L3b
                  \---L4
                           B
                           C
                           D
                    
Correct console output:

      A

      B

      C

      D
   
      E

      F

      G
