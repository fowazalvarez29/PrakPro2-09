/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jenis_member; // Mendefinisikan package 'jenis_member' untuk kelas-kelas terkait dengan jenis member.

/**
 *
 * @author alvarez // Komentar yang menyatakan penulis kelas ini.
 */
public class JenisMember { // Mendefinisikan kelas JenisMember.

    private String id; // Mendeklarasikan variabel id untuk menyimpan ID jenis member.
    private String nama; // Mendeklarasikan variabel nama untuk menyimpan nama jenis member.
    
    public void setId(String id) { // Metode untuk mengatur nilai ID jenis member.
        this.id = id; // Menetapkan nilai id dengan nilai yang diberikan.
    }
    
    public String getId() { // Metode untuk mendapatkan nilai ID jenis member.
        return id; // Mengembalikan nilai id.
    }
    
    public void setNama(String nama) { // Metode untuk mengatur nama jenis member.
        this.nama = nama; // Menetapkan nilai nama dengan nilai yang diberikan.
    }
    
    public String getNama() { // Metode untuk mendapatkan nama jenis member.
        return nama; // Mengembalikan nilai nama.
    }
    
}
