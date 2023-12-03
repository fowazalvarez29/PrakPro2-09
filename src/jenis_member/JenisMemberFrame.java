/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jenis_member; // Mendefinisikan package 'jenis_member' untuk kelas-kelas terkait dengan jenis member.

import java.awt.event.*; // Mengimpor kelas-kelas event dari paket java.awt untuk menangani event.
import javax.swing.*; // Mengimpor kelas-kelas GUI dari paket javax.swing untuk membangun antarmuka pengguna.
import javax.swing.table.*; // Mengimpor kelas-kelas terkait JTable dari paket javax.swing.table untuk bekerja dengan tabel.
import java.util.*; // Mengimpor kelas-kelas terkait koleksi dari paket java.util.
import dao.JenisMemberDao; // Mengimpor kelas JenisMemberDao dari paket dao untuk mengakses data jenis member.

/**
 *
 * @author alvarez // Komentar yang menyatakan penulis kelas ini.
 */
public class JenisMemberFrame extends JFrame { // Mendefinisikan kelas JenisMemberFrame yang merupakan turunan dari JFrame.

    private List<JenisMember> jenisMemberList; // Mendeklarasikan list untuk menyimpan objek jenis member.
    private JTextField textFieldNama; // Mendeklarasikan JTextField untuk input nama jenis member.
    private JenisMemberTableModel tableModel; // Mendeklarasikan JenisMemberTableModel untuk model tabel jenis member.
    private JenisMemberDao jenisMemberDao; // Mendeklarasikan JenisMemberDao untuk akses data jenis member.
    
    public JenisMemberFrame(JenisMemberDao jenisMemberDao) { // Konstruktor kelas JenisMemberFrame.
        this.jenisMemberDao = jenisMemberDao; // Menginisialisasi jenisMemberDao dengan nilai yang diberikan.
        this.jenisMemberList = jenisMemberDao.findAll(); // Mendapatkan daftar jenis member dari basis data menggunakan JenisMemberDao.
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Menetapkan operasi default saat menutup jendela.
        
        JLabel labelInput = new JLabel("Nama: "); // Membuat label untuk input nama jenis member.
        labelInput.setBounds(15, 40, 350, 10); // Menetapkan posisi dan ukuran label.
        
        textFieldNama = new JTextField(); // Membuat JTextField untuk input nama jenis member.
        textFieldNama.setBounds(15, 60, 350, 30); // Menetapkan posisi dan ukuran JTextField.
        
        JButton button = new JButton("Simpan"); // Membuat tombol "Simpan".
        button.setBounds(15, 100, 100, 40); // Menetapkan posisi dan ukuran tombol.
        
        javax.swing.JTable table = new JTable(); // Membuat JTable untuk menampilkan data jenis member.
        JScrollPane scrollableTable = new JScrollPane(table); // Membuat JScrollPane untuk JTable agar bisa di-scroll.
        scrollableTable.setBounds(15, 150, 350, 200); // Menetapkan posisi dan ukuran JScrollPane.
        
        tableModel = new JenisMemberTableModel(jenisMemberList); // Menginisialisasi model tabel dengan data jenis member.
        table.setModel(tableModel); // Menetapkan model pada JTable.
        
        JenisMemberButtonSimpanActionListener actionListener = new JenisMemberButtonSimpanActionListener(this, jenisMemberDao); // Membuat objek listener untuk tombol "Simpan".
        button.addActionListener(actionListener); // Menambahkan listener pada tombol "Simpan".
        
        this.add(button); // Menambahkan tombol "Simpan" ke dalam frame.
        this.add(textFieldNama); // Menambahkan JTextField ke dalam frame.
        this.add(labelInput); // Menambahkan label untuk input nama ke dalam frame.
        this.add(scrollableTable); // Menambahkan JScrollPane dengan JTable ke dalam frame.
        
        this.setSize(400, 500); // Menetapkan ukuran frame.
        this.setLayout(null); // Menetapkan layout frame menjadi null layout.
    }
    
    public String getNama() { // Metode untuk mendapatkan nilai dari input nama jenis member.
        return textFieldNama.getText(); // Mengembalikan nilai yang ada di dalam JTextField.
    }
    
    public void addJenisMember(JenisMember jenisMember) { // Metode untuk menambahkan jenis member ke dalam tabel.
        tableModel.add(jenisMember); // Menambahkan jenis member ke dalam model tabel.
        textFieldNama.setText(""); // Mengosongkan input nama setelah jenis member ditambahkan.
    }

}
