/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package member; // Mendefinisikan package 'member' untuk kelas-kelas terkait dengan anggota.

import jenis_member.JenisMember; // Mengimpor kelas JenisMember dari paket jenis_member.
import java.awt.event.*; // Mengimpor kelas-kelas event dari paket java.awt untuk menangani event.
import java.util.UUID; // Mengimpor kelas UUID dari paket java.util untuk membuat UUID (Universal Unique Identifier).
import dao.MemberDao; // Mengimpor kelas MemberDao dari paket dao untuk mengakses data anggota.

/**
 *
 * @author alvarez // Komentar yang menyatakan penulis kelas ini.
 */
public class MemberButtonSimpanActionListener implements ActionListener { // Mendefinisikan kelas MemberButtonSimpanActionListener yang mengimplementasikan ActionListener.

    private MemberFrame memberFrame; // Mendeklarasikan variabel memberFrame untuk mereferensikan objek MemberFrame.
    private MemberDao memberDao; // Mendeklarasikan variabel memberDao untuk mereferensikan objek MemberDao.
    
    public MemberButtonSimpanActionListener(MemberFrame memberFrame, MemberDao memberDao) { // Konstruktor kelas MemberButtonSimpanActionListener.
        this.memberFrame = memberFrame; // Menginisialisasi memberFrame dengan nilai yang diberikan.
        this.memberDao = memberDao; // Menginisialisasi memberDao dengan nilai yang diberikan.
    }
    
    public void actionPerformed(ActionEvent e) { // Metode actionPerformed yang diimplementasikan dari ActionListener.
        String nama = this.memberFrame.getNama(); // Mendapatkan nama dari MemberFrame.
        if (nama.isEmpty()) { // Memeriksa apakah nama kosong.
            this.memberFrame.showAlert("Nama Tidak Boleh Kosong"); // Menampilkan pesan kesalahan jika nama kosong.
        } else {
            JenisMember jenisMember = this.memberFrame.getJenisMember(); // Mendapatkan jenis anggota dari MemberFrame.
            Member member = new Member(); // Membuat objek Member.
            member.setId(UUID.randomUUID().toString()); // Mengatur ID anggota dengan UUID acak.
            member.setNama(nama); // Mengatur nama anggota dengan nilai yang diberikan.
            member.setJenisMember(jenisMember); // Mengatur jenis anggota dengan nilai yang diberikan.
            
            this.memberFrame.addMember(member); // Menambahkan anggota ke MemberFrame.
            this.memberDao.insert(member); // Menyimpan anggota ke dalam basis data menggunakan MemberDao.
        }
    }
    
}
