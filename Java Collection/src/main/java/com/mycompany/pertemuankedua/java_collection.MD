Rangkuman Materi:
  Java memiliki class atau container atau interface seperti iterable, collection, list, queue, dequeue, dst.

  - Iterable merupakan parent dari semua collection kecuali map dan digunakan untuk meng-iterasi data
  - Iterator dapat digunakan untuk mengembalikan objek Iterable (Untuk java 5 keatas dapat menggunakan for each)
  - Collection merupakan class berisi method untuk memanipulasi data collection, seperti menambah, menghapus dan mengecek isi data collection tetapi tidak dapat diimplementasi secara langsung karena akan dipecah menjadi beberapa class lain seperti List, Set, dan Queue.
  - List merupakan data collection yang bisa dimasukkan data duplikat, diurutkan sesuai posisi memasukan data, dan menggunakan nomor index
  - ArrayList merupakan implementasi list menggunakan array dimana ketika memasukkan data melebihi kapasitas, arrayList akan membuat array baru dengan kapasitas baru dengan ukuran kapasitas lama + data baru
  - LinkedList adalah implementasi List dengan struktur data Double Linked List
  - Keunggulan ArrayList terhadap LinkedList adalah kecepatan dalam operasi get dan set
  - sedangkan keunggulan LinkedList terhadap ArrayList adalah kecepatan dalam operasi add dan remove
  - Queue adalah implementasi dari struktur data Antrian atau FIFO (First In First Out)
  - Deque atau double ended queue, artinya queue yang bisa beroperasi dari depan atau belakang
  - Deque bisa FIFO ataupun LIFO
  
