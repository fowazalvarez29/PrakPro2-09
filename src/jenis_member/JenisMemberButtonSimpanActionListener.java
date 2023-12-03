/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jenis_member; // Mendefinisikan package 'jenis_member' untuk kelas-kelas terkait dengan jenis member.

import java.awt.event.*; // Mengimpor kelas-kelas event dari paket java.awt untuk menangani event.
import javax.swing.*; // Mengimpor kelas-kelas GUI dari paket javax.swing untuk membangun antarmuka pengguna.
import java.util.UUID; // Mengimpor kelas UUID dari paket java.util untuk membuat UUID (Universal Unique Identifier).
import dao.JenisMemberDao; // Mengimpor kelas JenisMemberDao dari paket dao untuk mengakses data jenis member.

/**
 *
 * @author alvarez // Komentar yang menyatakan penulis kelas ini.
 */
public class JenisMemberButtonSimpanActionListener implements ActionListener { // Mendefinisikan kelas JenisMemberButtonSimpanActionListener yang mengimplementasikan ActionListener.

    private JenisMemberFrame jenisMemberFrame; // Mendeklarasikan variabel jenisMemberFrame untuk mereferensikan objek JenisMemberFrame.
    private JenisMemberDao jenisMemberDao; // Mendeklarasikan variabel jenisMemberDao untuk mereferensikan objek JenisMemberDao.
    
    public JenisMemberButtonSimpanActionListener(JenisMemberFrame jenisMemberFrame, JenisMemberDao jenisMemberDao) { // Konstruktor kelas JenisMemberButtonSimpanActionListener.
        this.jenisMemberFrame = jenisMemberFrame; // Menginisialisasi jenisMemberFrame dengan nilai yang diberikan.
        this.jenisMemberDao = jenisMemberDao; // Menginisialisasi jenisMemberDao dengan nilai yang diberikan.
    }
    
    public  void actionPerformed(ActionEvent e) { // Metode actionPerformed yang diimplementasikan dari ActionListener.
        String nama = this.jenisMemberFrame.getNama(); // Mendapatkan nama dari JenisMemberFrame.       
        JenisMember jenisMember = new JenisMember(); // Membuat objek JenisMember.
        jenisMember.setId(UUID.randomUUID().toString()); // Mengatur ID jenis member dengan UUID acak.
        jenisMember.setNama(nama); // Mengatur nama jenis member dengan nilai yang diberikan.
        
        this.jenisMemberFrame.addJenisMember(jenisMember); // Menambahkan jenis member ke JenisMemberFrame.
        this.jenisMemberDao.insert(jenisMember); // Menyimpan jenis member ke dalam basis data menggunakan JenisMemberDao.
    }
    
}