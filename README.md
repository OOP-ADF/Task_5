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
 ![01](https://cloud.githubusercontent.com/assets/13241336/26094527/8deb10d2-3a44-11e7-950d-2f1382498e87.JPG)<br>
* Import library berikut pada kelas Application<br>
 ![02](https://cloud.githubusercontent.com/assets/13241336/26094529/8decf6fe-3a44-11e7-96f8-90e42d31b45b.JPG) <br>
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
![03](https://cloud.githubusercontent.com/assets/13241336/26094531/8defd2f2-3a44-11e7-9056-0f0e6ca002c1.JPG) <br>
 * tambahkan catch FileNotFoundException jika file pada filepath tidak ditemukan
 * tambahkan catch JavaLayerException jika terjadi error saat memainkan musik
 * isi catch melempar new IllegalStateException 
![04](https://cloud.githubusercontent.com/assets/13241336/26094528/8dec21f2-3a44-11e7-8bd2-7c3ecebd463a.JPG)<br>

#### b. Constructor Application
* Menginstansiasi Arraylist musicList baru

#### c. method addMusic( String path )
* Menambahkan String path ke dalam ArrayList musicList

#### d. method getMusicList()
* mengembalikan ArrayList musicList dalam bentuk array String<br>
![05](https://cloud.githubusercontent.com/assets/13241336/26094530/8dee5cc4-3a44-11e7-9424-4211bbcaa1fa.JPG)<br>

#### e. method getNowPlayed()
* mengembalikan String path music yang sedang diputar<br>
![06](https://cloud.githubusercontent.com/assets/13241336/26094532/8df3d7b2-3a44-11e7-8bad-4c1edb4cefad.JPG) <br>

#### f. method removeMusic( int i )
* menghapus String path ke-i dari musicList

#### g. method play( int i )
* method akan memutar lagu ke-i dari dalam musicList
* set nowplaying = i
* ambil String path music ke-i dari musicList
* instansiasi objek ThreadPlayer baru menggunakan String path yang diambil
* jalankan objek ThreadPlayer dengan memanggil method start()<br>
![07](https://cloud.githubusercontent.com/assets/13241336/26094534/8e1c3ef0-3a44-11e7-9f5d-b7339d5abeb8.JPG)<br>

#### h. method stop()
* method menghentikan music yang sedang diputar dengan menghentikan thread yang sedang berjalan<br>
![08](https://cloud.githubusercontent.com/assets/13241336/26094533/8e1af00e-3a44-11e7-8107-0fef9dd9e5a9.JPG) <br>

#### i. method next()
* method menghentikan music yang sedang diputar 
* memainkan music yang berada di setelah music yang sedang diputar di dalam listMusic
* method dipanggil jika nowPlaying bukanlah music terakhir di dalam listMusic<br>
![09](https://cloud.githubusercontent.com/assets/13241336/26094536/8e3372a0-3a44-11e7-8a8e-1dfc4eb36a2e.JPG)<br>

#### j. method prev()
* method menghentikan music yang sedang diputar 
* memainkan music yang berada di sebelum music yang sedang diputar di dalam listMusic
* method dipanggil jika nowPlaying bukanlah music pertama di dalam listMusic<br>
	![10] (/asset/10.JPG) <br>

### 2. PlayerGui.java
* Buatlah class JFrame PlayerGui.java dengan tampilan sebagai berikut <br>
![11](https://cloud.githubusercontent.com/assets/13241336/26094538/8e37d4ee-3a44-11e7-815c-9c025a2a5c04.JPG) <br>
* Komponen yang ada : 
 * listMusic : JList 
 * txFieldPlaying : JTextField, set Editable = false
 * btnAdd, btnDelete, btnPrev, btnPlay, btnStop, btnNext
* hapus main method (psvm) di dalam GUI
* tambahkan method getter objek untuk mengembalikan setiap objek button<br>
![12](https://cloud.githubusercontent.com/assets/13241336/26094537/8e36b60e-3a44-11e7-9b2e-94b2df7fe2d8.JPG) <br>
* method void setListMusic( String[] musicList )
 * method mengeset JList listMusic dengan data musicList dengan memanggil method setListData<br>
![13](https://cloud.githubusercontent.com/assets/13241336/26094535/8e28eec0-3a44-11e7-933f-7e2fc381bc8a.JPG)<br>
* method void setTxFieldPlaying( String filename )
  * method mengeset text field txFieldPlaying dengan string filename dengan memanggil method setText 
* method int getSelectedMusic()
  * method mengembalikan integer index list yang dipilih dari JList listMusic
  * method melemparkan new IllegalStateException jika tidak ada music yang dipilih dari listMusic<br>
![14](https://cloud.githubusercontent.com/assets/13241336/26094539/8e4b21e8-3a44-11e7-8718-00d63f78d86a.JPG) <br>
* import java.awt.event.ActionListener
* method void addListener(ActionListener e)
 * tambahkan add listener pada setiap tombol dengan memanggil method addActionListener<br>
![15](https://cloud.githubusercontent.com/assets/13241336/26094540/8e50028a-3a44-11e7-9f05-093587deefdb.JPG) <br>

### 3. Controller.java
* Buatlah class Controller.java sesuai class diagram berikut <br>
![17](https://cloud.githubusercontent.com/assets/13241336/26094543/8e699d76-3a44-11e7-8a10-208035506f19.JPG) <br>
* import library berikut<br>
![16](https://cloud.githubusercontent.com/assets/13241336/26094542/8e5b3c72-3a44-11e7-98fb-668f234ab8f3.JPG) <br>
* kelas Controller <b> implements ActionListener </b>
* implementasikan method actionPerformed(ActionEvent ae)

#### a. Constructor Controller
* Constructor menginstansiasi Application app
* Constructor menginstansiasi GUI view
* set visible view = true
* set lisener view dengan controller this
* set view listMusic dengan musicList dari objek app <br>
![18](https://cloud.githubusercontent.com/assets/13241336/26094544/8e6d0736-3a44-11e7-9530-05f35a747bce.JPG)<br>

#### b. Method actionPerformed(ActionEvent ae)
* get Object source action event<br>
![19](https://cloud.githubusercontent.com/assets/13241336/26094545/8e6e05b4-3a44-11e7-8bd7-a5414761d2e4.JPG)<br>
* lakukan proses berikut dalam blok <b> try-catch </b>
  * cek source action event
  * jika event berasal dari tombol add : <br>
![21](https://cloud.githubusercontent.com/assets/13241336/26094547/8e80f3f4-3a44-11e7-94e6-42aa004c28c8.JPG) <br>
    * Instansiasi objek JFileChooser() untuk membuka window file chooser
    * set filter file *.mp3
    * tampilkan JFileChooser dari view GUI<br>
![20](https://cloud.githubusercontent.com/assets/13241336/26094546/8e793c4a-3a44-11e7-981d-adacd8628b29.JPG)<br>
    * jika file mp3 telah dipilih, ambil absolute path dari file
    * tambahkan file path music ke dalam musicList objek app
![22](https://cloud.githubusercontent.com/assets/13241336/26094548/8e8b5830-3a44-11e7-8364-68a00288126f.JPG) <br>
  * jika event berasal dari tombol delete : 
    * ambil index music yang dipilih dari listMusic menggunakan method getSelectedMusic
    * hapus path music yang dipilih pada objek app
    * update tampulan listMusic<br>
![23](https://cloud.githubusercontent.com/assets/13241336/26094549/8e98eed2-3a44-11e7-9fab-789bd228ede1.JPG)<br>
  * jika event berasal dari tombol play : 
    * ambil index music yang dipilih dari listMusic menggunakan method getSelectedMusic
    * stop music yang sedang berjalan
    * play music dengan index music yang dipilih
    * update text field playing dengan mengambil string getNowPlayed()<br>
![24](https://cloud.githubusercontent.com/assets/13241336/26094550/8e9d8c9e-3a44-11e7-8279-2ce8c0230909.JPG)<br>
  * jika event berasal dari tombol stop : 
    * stop music yang sedang berjalan
    * hapus text di dalam text field playing<br>
![25](https://cloud.githubusercontent.com/assets/13241336/26094551/8ea02080-3a44-11e7-877d-96959640da86.JPG)<br>
  * jika event berasal dari tombol next : 
    * panggil method next() dari objek app
    * update text field playing<br>
![26](https://cloud.githubusercontent.com/assets/13241336/26094552/8eac22e0-3a44-11e7-963b-5c364895535a.JPG) <br>
  * jika event berasal dari tombol prev : 
    * panggil method prev() dari objek app
    * update text field playing<br>
![27](https://cloud.githubusercontent.com/assets/13241336/26094554/8ebc30c2-3a44-11e7-8240-ad5c4247a470.JPG) <br>
* pada blok <b>catch</b> tampilkan window JOptionPane dan tampilkan pesan error yang didapat<br>
![28](https://cloud.githubusercontent.com/assets/13241336/26094553/8ebb2a38-3a44-11e7-8358-51fe495eebd1.JPG) <br>

### 4. Driver.java
* Buatlah class Driver.java yang memiliki main method (psvm)
* instansiasi objek Controller()
* cobalah aplikasi music player yang telah dibuat
