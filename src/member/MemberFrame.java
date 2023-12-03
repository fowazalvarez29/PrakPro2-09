/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package member; // Mendefinisikan package 'member' untuk kelas-kelas terkait dengan anggota.

import jenis_member.JenisMember; // Mengimpor kelas JenisMember dari paket jenis_member.
import java.awt.event.*; // Mengimpor kelas-kelas event dari paket java.awt untuk menangani event.
import javax.swing.*; // Mengimpor kelas-kelas GUI dari paket javax.swing untuk membangun antarmuka pengguna.
import javax.swing.table.*; // Mengimpor kelas-kelas terkait JTable dari paket javax.swing.table untuk bekerja dengan tabel.
import java.util.*; // Mengimpor kelas-kelas terkait koleksi dari paket java.util.
import dao.MemberDao; // Mengimpor kelas MemberDao dari paket dao untuk mengakses data anggota.
import dao.JenisMemberDao; // Mengimpor kelas JenisMemberDao dari paket dao untuk mengakses data jenis anggota.

/**
 *
 * @author alvarez // Komentar yang menyatakan penulis kelas ini.
 */
public class MemberFrame extends JFrame { // Mendefinisikan kelas MemberFrame yang merupakan turunan dari JFrame.

    private List<JenisMember> jenisMemberList; // Mendeklarasikan list untuk menyimpan objek jenis anggota.
    private List<Member> memberList; // Mendeklarasikan list untuk menyimpan objek anggota.
    private JTextField textFieldNama; // Mendeklarasikan JTextField untuk input nama anggota.
    private MemberTableModel tableModel; // Mendeklarasikan MemberTableModel untuk model tabel anggota.
    private JComboBox comboJenis; // Mendeklarasikan JComboBox untuk memilih jenis anggota.
    private MemberDao memberDao; // Mendeklarasikan MemberDao untuk akses data anggota.
    private JenisMemberDao jenisMemberDao; // Mendeklarasikan JenisMemberDao untuk akses data jenis anggota.

    public MemberFrame(MemberDao memberDao, JenisMemberDao jenisMemberDao) { // Konstruktor kelas MemberFrame.
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Menetapkan operasi default saat menutup jendela.

        this.memberDao = memberDao; // Menginisialisasi memberDao dengan nilai yang diberikan.
        this.jenisMemberDao = jenisMemberDao; // Menginisialisasi jenisMemberDao dengan nilai yang diberikan.

        this.memberList = memberDao.findAll(); // Mendapatkan daftar anggota dari basis data menggunakan MemberDao.
        this.jenisMemberList = jenisMemberDao.findAll(); // Mendapatkan daftar jenis anggota dari basis data menggunakan JenisMemberDao.

        JLabel labelInput = new JLabel("Nama: "); // Membuat label untuk input nama anggota.
        labelInput.setBounds(15, 40, 350, 10); // Menetapkan posisi dan ukuran label.

        textFieldNama = new JTextField(); // Membuat JTextField untuk input nama anggota.
        textFieldNama.setBounds(15, 60, 350, 30); // Menetapkan posisi dan ukuran JTextField.

        JLabel labelJenis = new JLabel("Jenis Member: "); // Membuat label untuk pilihan jenis anggota.
        labelJenis.setBounds(15, 100, 350, 10); // Menetapkan posisi dan ukuran label.

        comboJenis = new JComboBox(); // Membuat JComboBox untuk memilih jenis anggota.
        comboJenis.setBounds(15, 120, 150, 30); // Menetapkan posisi dan ukuran JComboBox.

        JButton button = new JButton("Simpan"); // Membuat tombol "Simpan".
        button.setBounds(15, 160, 100, 40); // Menetapkan posisi dan ukuran tombol.

        javax.swing.JTable table = new JTable(); // Membuat JTable untuk menampilkan data anggota.
        JScrollPane scrollableTable = new JScrollPane(table); // Membuat JScrollPane untuk JTable agar bisa di-scroll.
        scrollableTable.setBounds(15, 220, 350, 200); // Menetapkan posisi dan ukuran JScrollPane.

        tableModel = new MemberTableModel(memberList); // Menginisialisasi model tabel dengan data anggota.
        table.setModel(tableModel); // Menetapkan model pada JTable.

        MemberButtonSimpanActionListener actionListener = new MemberButtonSimpanActionListener(this, memberDao); // Membuat objek listener untuk tombol "Simpan".
        button.addActionListener(actionListener); // Menambahkan listener pada tombol "Simpan".

        this.add(button); // Menambahkan tombol "Simpan" ke dalam frame.
        this.add(textFieldNama); // Menambahkan JTextField ke dalam frame.
        this.add(labelInput); // Menambahkan label untuk input nama ke dalam frame.
        this.add(labelJenis); // Menambahkan label untuk pilihan jenis anggota ke dalam frame.
        this.add(comboJenis); // Menambahkan JComboBox ke dalam frame.
        this.add(scrollableTable); // Menambahkan JScrollPane dengan JTable ke dalam frame.

        this.setSize(400, 500); // Menetapkan ukuran frame.
        this.setLayout(null); // Menetapkan layout frame menjadi null layout.
    }

    public void populateComboJenis() { // Metode untuk mengisi JComboBox dengan jenis anggota.
        this.jenisMemberList = this.jenisMemberDao.findAll(); // Mendapatkan daftar jenis anggota dari basis data menggunakan JenisMemberDao.
        comboJenis.removeAllItems(); // Menghapus semua item dari JComboBox.
        for (JenisMember jenisMember : this.jenisMemberList) { // Iterasi melalui daftar jenis anggota.
            comboJenis.addItem(jenisMember.getNama()); // Menambahkan nama jenis anggota ke dalam JComboBox.
        }
    }

    public String getNama() { // Metode untuk mendapatkan nilai dari input nama anggota.
        return textFieldNama.getText(); // Mengembalikan nilai yang ada di dalam JTextField.
    }

    public JenisMember getJenisMember() { // Metode untuk mendapatkan jenis anggota yang dipilih dari JComboBox.
        return jenisMemberList.get(comboJenis.getSelectedIndex()); // Mengembalikan jenis anggota yang dipilih dari daftar jenis anggota.
    }

    public void addMember(Member member) { // Metode untuk menambahkan anggota ke dalam tabel.
        tableModel.add(member); // Menambahkan anggota ke dalam model tabel.
        textFieldNama.setText(""); // Mengosongkan input nama setelah anggota ditambahkan.
    }

    public void showAlert(String message) { // Metode untuk menampilkan pesan alert.
        JOptionPane.showMessageDialog(this, message); // Menampilkan pesan alert dengan pesan yang diberikan.
    }

}
