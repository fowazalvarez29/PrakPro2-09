/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jenis_member; // Mendefinisikan package 'jenis_member' untuk kelas-kelas terkait dengan jenis member.

import javax.swing.table.*; // Mengimpor kelas-kelas terkait JTable dari paket javax.swing.table untuk bekerja dengan tabel.
import java.util.List; // Mengimpor kelas List dari paket java.util untuk mengelola koleksi objek.

/**
 *
 * @author alvarez // Komentar yang menyatakan penulis kelas ini.
 */
public class JenisMemberTableModel extends AbstractTableModel { // Mendefinisikan kelas JenisMemberTableModel yang merupakan turunan dari AbstractTableModel.

    private String[] columnNames = {"Nama"}; // Mendeklarasikan array kolom dengan nama "Nama".
    private List<JenisMember> data; // Mendeklarasikan list untuk menyimpan objek jenis member.
    
    public JenisMemberTableModel(List<JenisMember> data) { // Konstruktor kelas JenisMemberTableModel.
        this.data = data; // Menginisialisasi data dengan nilai yang diberikan.
    }
    
    public int getColumnCount() { // Metode untuk mendapatkan jumlah kolom.
        return columnNames.length; // Mengembalikan panjang array kolom.
    }
    
    public int getRowCount() { // Metode untuk mendapatkan jumlah baris.
        return data.size(); // Mengembalikan ukuran data (jumlah objek jenis member dalam list).
    }
    
    public String getColumnName(int col) { // Metode untuk mendapatkan nama kolom berdasarkan indeks kolom.
        return columnNames[col]; // Mengembalikan nama kolom sesuai dengan indeks yang diberikan.
    }
    
    public Object getValueAt(int row, int col) { // Metode untuk mendapatkan nilai di posisi baris dan kolom tertentu.
        JenisMember rowItem = data.get(row); // Mengambil objek jenis member dari list berdasarkan indeks baris.
        String value = ""; // Variabel untuk menyimpan nilai yang akan dikembalikan.
        
        switch (col) { // Memilih kolom berdasarkan indeks.
            case 0:
                value = rowItem.getNama(); // Mendapatkan nilai nama dari objek jenis member.
                break;
        }
        return value; // Mengembalikan nilai sesuai dengan kolom yang dipilih.
    }
    
    public boolean isCellEditable(int row, int col) { // Metode untuk menentukan apakah sel di baris dan kolom tertentu dapat diubah atau tidak.
        return false; // Mengembalikan false karena sel dalam tabel ini tidak dapat diubah.
    }
    
    public void add(JenisMember value) { // Metode untuk menambahkan objek jenis member ke dalam model tabel.
        data.add(value); // Menambahkan objek jenis member ke dalam list data.
        fireTableRowsInserted(data.size() - 1, data.size() - 1); // Memberitahukan kepada tabel bahwa baris telah ditambahkan.
    }
    
}
