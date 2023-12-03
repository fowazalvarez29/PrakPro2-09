/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main; // Mendefinisikan package 'main' untuk kelas-kelas terkait dengan aplikasi utama.

import java.awt.event.*; // Mengimpor kelas-kelas event dari paket java.awt untuk menangani event.

/**
 *
 * @author alvarez // Komentar yang menyatakan penulis kelas ini.
 */

public class MainButtonActionListener implements ActionListener { // Mendefinisikan kelas MainButtonActionListener yang mengimplementasikan ActionListener.

    private MainFrame mainFrame; // Mendeklarasikan variabel mainFrame untuk merujuk ke frame utama aplikasi.

    public MainButtonActionListener(MainFrame mainFrame) { // Konstruktor kelas MainButtonActionListener.
        this.mainFrame = mainFrame; // Menginisialisasi mainFrame dengan nilai yang diberikan.
    }

    public void actionPerformed(ActionEvent e) { // Metode yang dipanggil ketika event terjadi.
        if (e.getSource() == mainFrame.getButtonJenisMember()) { // Memeriksa jika tombol Jenis Member ditekan.
            mainFrame.showJenisMemberFrame(); // Memanggil metode showJenisMemberFrame() di MainFrame.
        } else { // Jika bukan tombol Jenis Member yang ditekan.
            mainFrame.showMemberFrame(); // Memanggil metode showMemberFrame() di MainFrame.
        }
    }

}
