package com.varsha.pawpals.data

import com.varsha.pawpals.R
import com.varsha.pawpals.model.Artikel
import com.varsha.pawpals.model.KategoriArtikel

object DataArticle {
    val DataArtikel = listOf(
        Artikel(
                id = 1,
                title = "Cara Memberi Makan Kucing Unik",
                photo = R.drawable.mrfresh,
                description = "Bagaimana Cara Merencanakan Jadwal Makan Kucing Saya?\n" +
                        "Anda  dapat membagi diet harian kucing Anda menjadi dua bagian utama dengan  jeda tidak lebih dari 12 jam. Atau, Anda dapat membagi waktu makan  mereka menjadi beberapa kali  mulai dari sarapan, makan siang, dan makan  malam. Namun, pastikan bahwa makanan yang Anda berikan dapat memenuhi  kalori dan nutrisi lainnya, tidak lebih atau kurang dari yang  direkomendasikan."
        ),
        Artikel(
            id = 2,
            title = "Bagaimana Merawat Kucing Kesayanganmu?",
            photo = R.drawable.article_food,
            description = "Bagi Anda yang baru memelihara kucing dan masih bingung tentang perawatan dasarnya, berikut beberapa cara yang bisa dilakukan.\n" +
                    "1. Beri makan secara teratur\n" +
                    "Tips merawat kucing yang paling penting yaitu memberi makan sesuai kebutuhannya. Makanan kucing yang dipilih harus seimbang untuk tahap kehidupannya. \n" +
                    "Anda juga bisa memberikan anabul daging sapi, ayam, hati ayam, dan ikan yang sudah dimasak. Hindari daging mentah, busuk, atau ikan berduri kepada anabul.\n" +
                    "Selain itu, kucing harus diberi camilan sebanyak 5 – 10% dari makanan utamanya.\n" +
                    "Camilan kucing bermacam-macam, tetapi yang paling sering diberikan adalah wet food. Anda dapat memberikan wet food sebanyak 1 – 2 kali dalam seminggu.\n" +
                    "\n" +
                    "2. Beri tempat minum kucing\n" +
                    "Sama seperti manusia, kucing membutuhkan air minum untuk menjaga kesehatan.\n" +
                    "Dengan mencukupi kebutuhan minumnya, anabul dapat terhindar dari dehidrasi, penyakit infeksi saluran kemih, dan penyakit ginjal.\n" +
                    "Nah, Anda perlu mengetahui cara minum yang disukai kucing Anda.\n" +
                    "Jika Anda pernah melihat kucing minum dari keran atau mengais-ngais mangkuk airnya, kemungkinan ia lebih suka minum di air mengalir.\n" +
                    "Bila kucing menyukai air mengalir, sediakan tempat minum khusus yang terdapat pancuran air sehingga anabul mau minum dari mangkoknya. Jangan lupa ganti air minumnya 1 kali sehari. \n" +
                    "\n" +
                    "3. Sisir bulu kucing setiap hari\n" +
                    "Cara menjaga kesehatan kucing yang baik selanjutnya yaitu dengan menyisir bulu kucing setiap hari. Kebiasaan ini ternyata bisa mendekatkan Anda dengan kucing peliharaan. \n" +
                    "Anabul memang bisa membersihkan bulu-bulu rontok dengan menjilati dan merawat dirinya sendiri, tetapi Anda juga dapat membantunya dalam hal ini.\n" +
                    "Lagi pula, menyisir sambil mengelus-ngelus bulu kucing merupakan kegiatan yang menyenangkan.\n" +
                    "\n" +
                    "4. Sediakan litter box\n" +
                    "Pasir kucing salah satu hal penting dalam cara merawat kucing ialah menyediakan litter box alias kotak pasir untuk kucing buang air.\n" +
                    "Pilihlah pasir kucing yang tidak berdebu agar kucing tidak mudah bersin-bersin.\n" +
                    "Anda juga sebaiknya menyediakan tambahan litter box, setidaknya satu buah. Jika Anda memelihara 2 kucing, sediakan 3 litter box.\n" +
                    "Dengan adanya litter box ekstra, kucing Anda punya alternatif jika tidak ingin menggunakan kotak biasanya karena alasan tertentu.\n" +
                    "Lokasi menempatkan kotak pasir juga perlu Anda perhatikan. Pastikan kotak berada di tempat yang mudah diakses dan nyaman bagi kucing.\n" +
                    "Satu yang terpenting, pastikan litter box selalu dalam kondisi kering, jangan sampai lembab.\n" +
                    "\n" +
                    "5. Sediakan tempat menggaruk\n" +
                    "Ini adalah perilaku alami, sehat, dan penting bagi kucing. Sayangnya, perilaku ini bisa merusak berbagai perabotan di rumah, misalnya sofa atau karpet.\n" +
                    "Oleh karena itu, sediakan tiang garukan untuk kucing. Memang perlu beberapa waktu bagi kucing mengenali tiang garukan ini.\n" +
                    "\n" +
                    "6. Menjaga kebersihan kucing\n" +
                    "Kucing adalah hewan yang selalu menjaga kebersihan diri. Mereka bisa menghabiskan banyak waktu untuk membersihkan dirinya sendiri.\n" +
                    "Tidak perlu terlalu sering, cukup mandikan anabul 1 – 2 kali dalam sebulan. Memandikan kucing secara rutin juga mencegah masalah kutu kucing dan infeksi jamur.\n" +
                    "Memotong kuku kucing sekaligus membersihkan kotoran dan kuman yang menempel yang mana bisa berpindah ke barang-barang atau tubuh manusia.\n" +
                    "\n" +
                    "7. Ajak kucing main dan bersosialisasi\n" +
                    "Kucing adalah hewan peliharaan yang suka bermain dan penyayang. Untuk itu, penting bagi Anda memenuhi kebutuhannya ini dengan memberikan kucing waktu bermain. \n" +
                    "\n" +
                    "8. Lakukan vaksinasi sesuai jadwal\n" +
                    "Cara merawat kucing lainnya yaitu melakukan vaksinasi secara rutin.\n" +
                    "Vaksinasi pada kucing penting dilakukan untuk membentuk sistem kekebalan terhadap penyakit tertentu sehingga daya tahan tubuh kucing semakin baik.\n" +
                    "\n" +
                    "9. Rutin periksa kesehatan ke dokter hewan\n" +
                    "Meskipun kucing tampak sehat, Anda perlu membawanya ke dokter hewan secara rutin, minimal setahun sekali.\n" +
                    "\n" +
                    "10. Melakukan steril\n" +
                    "Steril kucing dapat mencegah penyakit reproduksi, seperti infeksi rahim, kanker ovarium, dan kanker payudara pada kucing betina. \n" +
                    "Sementara itu, manfaat steril pada kucing jantan yaitu mencegah gangguan prostat.\n" +
                    "\n" +
                    "11. Bersihkan tempat tidur kucing\n" +
                    "Lingkungan sekitar kucing juga harus diperhatikan, seperti tempat tidur kucing. Tempat tidur kucing harus selalu dibersihkan karena alasan kesehatan dan kenyamanan bagi kucing Anda. \n" +
                    "\n" +
                    "Hal ini karena tempat tidur yang kotor dapat menjadi tempat berkembang biaknya bakteri, jamur, kutu, dan tungau. Ini dapat menyebabkan infeksi kulit, masalah pernapasan, atau penyakit lain pada kucing Anda."

        ),
        Artikel(
            id = 3,
            title = "Cara merawat anjing agar tetap sehat",
            photo = R.drawable.article_dog,
            description = "Nah, agar kondisi anjing tetap prima, yuk simak cara merawat anjing dengan tepat berikut!\n" +
                    "1. Berikan Makan yang Bernutrisi\n" +
                    "Cara merawat anak anjing hingga dewasa adalah dengan memberikan makanan yang tepat. Tujuannya agar perkembangan hewan dapat sesuai dengan usianya.\n" +
                    "\n" +
                    "Makanan yang sehat saja tidaklah cukup. Kamu harus memberikan makanan dengan intensitas yang sesuai usianya.\n" +
                    "Adapun intensitas memberi makan anjing dilansir dari American Society for the Prevention of Cruelty to Animals (ASPCA) adalah sebagai berikut:\n" +
                    "Anak anjing berusia 8-12 minggu membutuhkan makan 4 kali sehari\n" +
                    "Anak anjing berusia 3-6 bulan membutuhkan makan 3 kali sehari\n" +
                    "Anak anjing berusia 6-12 bulan membutuhkan makan 2 kali sehari\n" +
                    "Anjing berusia 1 tahun ke atas biasanya cukup makan 1 kali sehari\n" +
                    "Untuk beberapa anjing, yang rentan kembung, beri makan 2 kali sehari dalam porsi kecil\n" +
                    "Berikan anjing makanan yang bernutrisi untuk memenuhi kebutuhan gizinya. \n" +
                    "\n" +
                    "2. Ajak Anjing Latihan Fisik\n" +
                    "Anjing membutuhkan olahraga untuk membakar kalori dan merangsang pikiran mereka agar tetap sehat. Olahraga fisik ini cenderung membantu anjing menghilangkan rasa bosan. Dengan demikian, anjing tidak stres, lebih patuh, dan terarah.\n" +
                    "\n" +
                    "\n" +
                    "3. Ajak Anjing Berjalan Setiap Hari\n" +
                    "Jalan-jalan dengan anjing merupakan bagian penting dari rutinitas latihan dan sosialisasi anjing. Setiap anjing biasanya memerlukan waktu yang teratur untuk berjalan.\n" +
                    "\n" +
                    "Durasi idealnya akan tergantung dengan kebutuhan masing-masing anjing. Sebab, ada anjing yang butuh jalan pendek untuk sekadar refreshing dan ada yang butuh jalan panjang untuk membakar energi mereka.\n" +
                    "\n" +
                    "\n" +
                    "4. Sediakan Tempat Istirahat\n" +
                    "Anjing membutuhkan tempat tinggal yang hangat dan tenang untuk beristirahat. Berikan anjing tempat tidur, selimut, dan bantal yang hangat dan bersih. Hal ini akan membantunya tidur lebih nyenyak.\n" +
                    "\n" +
                    "5. Berikan Teman Bermain atau Pengasuh\n" +
                    "Berikan Teman Bermain atau Pengasuh\n" +
                    "Anjing yang ditinggal sendirian di rumah bisa saja mengalami kesepian. Oleh karena itu, peliharanmu butuh kehadiranmu.\n" +
                    "\n" +
                    "6. Rutin Kunjungi Dokter Hewan\n" +
                    "Pantau terus kesehatan anjing dengan rutin mengunjungi dokter hewan. Pemeriksaan dan perawatan rutin ini bertujuan mendeteksi masalah kesehatan yang mungkin terjadi pada anjing sedini mungkin.\n" +
                    "\n" +
                    "7. Beri Vaksin\n" +
                    "Selain memberikan makanan bernutrisi dan kebutuhan sosialisasi, pastikan anjing kamu mendapatkan vaksin. Vaksin anjing diperlukan agar anjing dapat hidup sehat dan terhindar dari penyakit berbahaya.\n" +
                    "\n" +
                    "Disampaikan oleh drh. Jepriadi Kertawinata, “Vaksin untuk anjing umumnya ada 5 jenis, yaitu Vaksin DP (Distemper dan parvo), Vaksin PiBr (Parainfluenza dan Bordetella), Vaksin DHLP I (Distemper, Hepatitis, Leptospirosis, Parvo), Vaksin DHLP II + R ( Vaksin DHLP dan Rabies), dan Booster Rabies.”\n" +
                    "\n" +
                    "8. Hindarkan dari Kutu\n" +
                    "Membersihkan anjing dari kutu merupakan salah satu cara merawat anjing agar tetap sehat. Gunakan sisir kutu untuk menemukan dan menghilangkan kutu. Kutu dan caplak akan sering muncul di musim panas dan menimbulkan gatal.\n" +
                    "Jika kondisi ini tidak bisa kamu kendalikan, sebaiknya bicarakan dengan dokter hewan kamu untuk mendapatkan perawatan khusus.\n" +
                    "\n" +
                    "9. Jaga Kebersihan Anjing\n" +
                    "Kebersihan anjing harus terjaga agar anjing dapat hidup lebih sehat. Kebersihan anjing juga dapat memberikan dampak positif bagi pemiliknya.\n" +
                    "\n" +
                    "Sebab, ada beberapa penyakit anjing yang dapat menular ke manusia. Oleh karena itu, anjing wajib mandi rutin untuk menghilangkan kotoran dan kutu di badannya.\n" +
                    "\n" +
                    "Sebelum mandi, pastikan untuk menyisir dan memotong kuku anjing terlebih dahulu. Kamu dapat memandikan anjing dengan sabun mandi khusus yang dapat dibeli di toko hewan. Sabun ini sudah memiliki formula khusus untuk membersihkan kotoran pada anjing peliharaan."

        ),
    )

    val kategoriArtikel = listOf(
        KategoriArtikel(
            id = 1,
            tagname = "Pet Health",
            photo = R.drawable.article_dog,
            title = "Health care for your pet service"
        ),
        KategoriArtikel(
            id = 2,
            tagname = "Pet Food",
            photo = R.drawable.article_food,
            title = "Health food for your pets"
        ),
        KategoriArtikel(
            id = 3,
            tagname = "Pet Fashion",
            photo = R.drawable.article_fashion,
            title = "High fashion for your pets"
        ),
        KategoriArtikel(
            id = 4,
            tagname = "Pet Health",
            photo = R.drawable.article_dog,
            title = "Cara Merawat Anjing Seperti Anak Sendiri Bagian Pertama"
        ),
        KategoriArtikel(
            id = 5,
            tagname = "Pet Health",
            photo = R.drawable.article_dog,
            title = "Cara Merawat Anjing Seperti Anak Sendiri Bagian Pertama"
        )
    )
}