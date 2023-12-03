/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main; // Mendefinisikan package 'main' untuk kelas-kelas terkait dengan aplikasi utama.

import java.awt.FlowLayout; // Mengimpor kelas FlowLayout dari paket java.awt untuk mengatur tata letak.
import java.awt.event.*; // Mengimpor kelas-kelas event dari paket java.awt untuk menangani event.
import javax.swing.*; // Mengimpor kelas-kelas UI dari paket javax.swing untuk membangun antarmuka pengguna.
import javax.swing.table.*; // Mengimpor kelas AbstractTableModel dari paket javax.swing.table untuk mendefinisikan model tabel.
import java.util.*; // Mengimpor kelas List dari paket java.util untuk menangani koleksi data.
import member.MemberFrame; // Mengimpor kelas MemberFrame dari paket member untuk menampilkan antarmuka pengguna untuk data anggota.
import dao.*; // Mengimpor kelas-kelas dari package dao yang berkaitan dengan akses data.
import jenis_member.JenisMemberFrame; // Mengimpor kelas JenisMemberFrame dari paket jenis_member untuk menampilkan antarmuka pengguna untuk jenis anggota.

/**
 *
 * @author alvarez // Komentar yang menyatakan penulis kelas ini.
 */
public class MainFrame extends JFrame { // Mendefinisikan kelas MainFrame yang merupakan turunan dari JFrame untuk membangun frame utama aplikasi.

    private JenisMemberFrame jenisMemberFrame; // Variabel untuk menampung frame JenisMemberFrame.
    private MemberFrame memberFrame; // Variabel untuk menampung frame MemberFrame.
    private JButton buttonJenisMember; // Tombol untuk menampilkan JenisMemberFrame.
    private JButton buttonMember; // Tombol untuk menampilkan MemberFrame.
    private JenisMemberDao jenisMemberDao; // Objek untuk mengakses data jenis anggota.
    private MemberDao memberDao; // Objek untuk mengakses data anggota.

    public MainFrame() { // Konstruktor kelas MainFrame.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Mengatur aksi default ketika frame ditutup.

        this.setSize(400, 500); // Mengatur ukuran frame.

        this.jenisMemberDao = new JenisMemberDao(); // Menginisialisasi objek JenisMemberDao.
        this.memberDao = new MemberDao(); // Menginisialisasi objek MemberDao.

        this.jenisMemberFrame = new JenisMemberFrame(jenisMemberDao); // Menginisialisasi JenisMemberFrame dengan objek JenisMemberDao.
        this.memberFrame = new MemberFrame(memberDao, jenisMemberDao); // Menginisialisasi MemberFrame dengan objek MemberDao dan JenisMemberDao.

        this.setLayout(new FlowLayout()); // Mengatur tata letak frame dengan FlowLayout.
        MainButtonActionListener actionListener = new MainButtonActionListener(this); // Membuat objek listener untuk tombol.

        this.buttonJenisMember = new JButton("Jenis Member"); // Membuat tombol untuk Jenis Member.
        this.buttonMember = new JButton("Member"); // Membuat tombol untuk Member.

        this.buttonJenisMember.addActionListener(actionListener); // Menambahkan listener untuk tombol Jenis Member.
        this.buttonMember.addActionListener(actionListener); // Menambahkan listener untuk tombol Member.

        this.add(buttonJenisMember); // Menambahkan tombol Jenis Member ke frame.
        this.add(buttonMember); // Menambahkan tombol Member ke frame.
    }

    public JButton getButtonJenisMember() { // Metode untuk mendapatkan tombol Jenis Member.
        return buttonJenisMember; // Mengembalikan tombol Jenis Member.
    }

    public JButton getButtonMember() { // Metode untuk mendapatkan tombol Member.
        return buttonMember; // Mengembalikan tombol Member.
    }

    public void showJenisMemberFrame() { // Metode untuk menampilkan frame Jenis Member.
        if (jenisMemberFrame == null) { // Memeriksa jika JenisMemberFrame belum dibuat.
            jenisMemberFrame = new JenisMemberFrame(jenisMemberDao); // Membuat JenisMemberFrame baru.
        }
        jenisMemberFrame.setVisible(true); // Menampilkan JenisMemberFrame.
    }

    public void showMemberFrame() { // Metode untuk menampilkan frame Member.
        if (memberFrame == null) { // Memeriksa jika MemberFrame belum dibuat.
            memberFrame = new MemberFrame(memberDao, jenisMemberDao); // Membuat MemberFrame baru.
        }
        memberFrame.populateComboJenis(); // Memuat combo jenis anggota di MemberFrame.
        memberFrame.setVisible(true); // Menampilkan MemberFrame.
    }

    public static void main(String[] args) { // Metode utama aplikasi.
        javax.swing.SwingUtilities.invokeLater(new Runnable() { // Memulai aplikasi dalam thread event dispatching.
            public void run() { // Metode yang dijalankan saat thread dimulai.
                MainFrame f = new MainFrame(); // Membuat objek MainFrame.
                f.setVisible(true); // Menampilkan frame utama aplikasi.
            }
        });
    }

}
