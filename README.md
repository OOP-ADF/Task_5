# Task_5
Exercise on Inner Class, Exception and Threading


Buatlah program java Aplikasi Music Player sebagai berikut

### MusicPlayer
* Buatlah sebuah Java Project MusicPlayer</b>

### JLayer library
* Download library (jl 1.0.1.jar) dari link [JLayer] (http://www.javazoom.net/javalayer/javalayer.html)
* Add library jLayer pada project MusicPlayer

### 1. Application.java
* Buatlah kelas Application sebagai berikut <br>
 ![01] (/asset/01.JPG) <br>
* Import library berikut pada kelas Application<br>
 ![02] (/asset/02.JPG) <br>
* class ThreadPlayer merupakan <b> Inner Class </b>

#### a. inner class ThreadPlayer
* <b> extends Thread </b>
* constructor
 * menginisialisasi String filepath
* method run()
 * lakukan proses berikut dalam blok <b> try-catch </b>
 * Baca file yang diambil dari String filepath menggunakan FileInputStream
 * Instansiasi objek Player untuk memainkan file musik yang dibaca
 * Putar musik menggunakan method play() dari objek Player
  ![03] (/asset/03.JPG) <br>
 * tambahkan catch FileNotFoundException jika file pada filepath tidak ditemukan
 * tambahkan catch JavaLayerException jika terjadi error saat memainkan musik
 * isi catch melempar new IllegalStateException 
  ![04] (/asset/04.JPG) <br>

#### b. Constructor Application
* Menginstansiasi Arraylist musicList baru

#### c. method addMusic( String path )
* Menambahkan String path ke dalam ArrayList musicList

#### d. method getMusicList()
* mengembalikan ArrayList musicList dalam bentuk array String<br>
	![05] (/asset/05.JPG) <br>

#### e. method getNowPlayed()
* mengembalikan String path music yang sedang diputar<br>
	![06] (/asset/06.JPG) <br>

#### f. method removeMusic( int i )
* menghapus String path ke-i dari musicList

#### g. method play( int i )
* method akan memutar lagu ke-i dari dalam musicList
* set nowplaying = i
* ambil String path music ke-i dari musicList
* instansiasi objek ThreadPlayer baru menggunakan String path yang diambil
* jalankan objek ThreadPlayer dengan memanggil method start()<br>
	![07] (/asset/07.JPG) <br>

#### h. method stop()
* method menghentikan music yang sedang diputar dengan menghentikan thread yang sedang berjalan<br>
	![08] (/asset/08.JPG) <br>

#### i. method next()
* method menghentikan music yang sedang diputar 
* memainkan music yang berada di setelah music yang sedang diputar di dalam listMusic
* method dipanggil jika nowPlaying bukanlah music terakhir di dalam listMusic<br>
	![09] (/asset/09.JPG) <br>

#### j. method prev()
* method menghentikan music yang sedang diputar 
* memainkan music yang berada di sebelum music yang sedang diputar di dalam listMusic
* method dipanggil jika nowPlaying bukanlah music pertama di dalam listMusic<br>
	![10] (/asset/10.JPG) <br>

### 2. PlayerGui.java
* Buatlah class JForm PlayerGui.java dengan tampilan sebagai berikut <br>
![11] (/asset/11.JPG) <br>
* Komponen yang ada : 
 * listMusic : JList 
 * txFieldPlaying : JTextField, set Editable = false
 * btnAdd, btnDelete, btnPrev, btnPlay, btnStop, btnNext
* hapus main method (psvm) di dalam GUI
* tambahkan method getter objek untuk mengembalikan setiap objek button<br>
	![12] (/asset/12.JPG) <br>
* method void setListMusic( String[] musicList )
 * method mengeset JList listMusic dengan data musicList dengan memanggil method setListData<br>
	![13] (/asset/13.JPG) <br>
* method void setTxFieldPlaying( String filename )
  * method mengeset text field txFieldPlaying dengan string filename dengan memanggil method setText 
* method int getSelectedMusic()
  * method mengembalikan integer index list yang dipilih dari JList listMusic
  * method melemparkan new IllegalStateException jika tidak ada music yang dipilih dari listMusic<br>
	![14] (/asset/14.JPG) <br>
* import java.awt.event.ActionListener
* method void addListener(ActionListener e)
 * tambahkan add listener pada setiap tombol dengan memanggil method addActionListener<br>
	![15] (/asset/15.JPG) <br>

### 3. Controller.java
* Buatlah class Controller.java sesuai class diagram berikut <br>
	![17] (/asset/17.JPG) <br>
* import library berikut<br>
	![16] (/asset/16.JPG) <br>
* kelas Controller <b> implements ActionListener </b>
* implementasikan method actionPerformed(ActionEvent ae)

#### a. Constructor Controller
* Constructor menginstansiasi Application app
* Constructor menginstansiasi GUI view
* set visible view = true
* set lisener view dengan controller this
* set view listMusic dengan musicList dari objek app <br>
	![18] (/asset/18.JPG) <br>

#### b. Method actionPerformed(ActionEvent ae)
* get Object source action event<br>
	![19] (/asset/19.JPG) <br>
* lakukan proses berikut dalam blok <b> try-catch </b>
  * cek source action event
  * jika event berasal dari tombol add : <br>
	![21] (/asset/21.JPG) <br>
    * Instansiasi objek JFileChooser() untuk membuka window file chooser
    * set filter file *.mp3
    * tampilkan JFileChooser dari view GUI<br>
	![20] (/asset/20.JPG) <br>
    * jika file mp3 telah dipilih, ambil absolute path dari file
    * tambahkan file path music ke dalam musicList objek app
    * update tampilan listMusic<br>
	![22] (/asset/22.JPG) <br>
  * jika event berasal dari tombol delete : 
    * ambil index music yang dipilih dari listMusic menggunakan method getSelectedMusic
    * hapus path music yang dipilih pada objek app
    * update tampulan listMusic<br>
	![23] (/asset/23.JPG) <br>
  * jika event berasal dari tombol play : 
    * ambil index music yang dipilih dari listMusic menggunakan method getSelectedMusic
    * stop music yang sedang berjalan
    * play music dengan index music yang dipilih
    * update text field playing dengan mengambil string getNowPlayed()<br>
	![24] (/asset/24.JPG) <br>
  * jika event berasal dari tombol stop : 
    * stop music yang sedang berjalan
    * hapus text di dalam text field playing<br>
	![25] (/asset/25.JPG) <br>
  * jika event berasal dari tombol next : 
    * panggil method next() dari objek app
    * update text field playing<br>
	![26] (/asset/26.JPG) <br>
  * jika event berasal dari tombol prev : 
    * panggil method prev() dari objek app
    * update text field playing<br>
	![27] (/asset/27.JPG) <br>
* pada blok <b>catch</b> tampilkan window JOptionPane dan tampilkan pesan error yang didapat<br>
	![28] (/asset/28.JPG) <br>

### 4. Driver.java
* Buatlah class Driver.java yang memiliki main method (psvm)
* instansiasi objek Controller()
* cobalah aplikasi music player yang telah dibuat
