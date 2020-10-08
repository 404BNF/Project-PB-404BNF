package com.example.myapplication.model;

import java.util.ArrayList;
import java.util.List;


public class MainDataModel {
    public static List<MainModel> gamesList() {
        MainModel angkot1 = new MainModel("Trayek A1", "Rute: Terminal Angkutan Kota - Jl. Adyaksa - Jl. Merdeka - Jl. Kolonel Sugiri - Jl. Jendral Gatoto Subroto - Jl. Ahmad Yani - Jl. Jendral Soedirman - Jl. Kolonel Sugiyono - Jl. Pramuka - Jl. DI.Panjaitan - Jl. Brigjen Katamso - Balai Desa - Terminal Angkutan Kota");
        MainModel angkot2 = new MainModel("Trayek A2", "Rute: Terminal Angkutan Kota - Jl. KB. Suprapto - Jl. MT. Haryono - Jl. Jendral Soedirman - Pasar Wage - Karanglewas - Monumen Pangsar Soedirman - Jl. RA Wiriatmaja - Jl. Jendral Gatot Subroto - Jl. AhmadYani - Jl. Dr. Angka - Jl. Kesatrian - Jl. Jendral Gatot Subroto - Terminal Angkutan Kota");
        MainModel angkot3 = new MainModel("Trayek B1", "Rute: Terminal Bus - Jl. Sultan Agung - Jl. Wakhid Hasyim - Jl. S. Parman - Jl. Jendral Suprapto -Terminal Angkot - Jl. HR. Bunyamin - Jl. Letjen Pol Sumarto - Jl. Ahmad Yani - Jl. Jendral Gatot Subroto - Jl. RA Wiriatmaja - Jl. Jendral Soedirman - Jl. Jendral Sutoyo - Jl. Pahlawan - Jl. Gerilya - Jl. Suwatio - Terminal Bus");
        MainModel angkot4 = new MainModel("Trayek B2", "Rute: Terminal Bus - Jl. Sultan Agung - Jl. Notosuwiryo - Jl. Gerilya - Jl. Pahlawan - Jl. Jendral Sutoyo - Jl. Jendral Soedirman - Jl. Masjid - Jl. Ahmad Yani - Jl. Letjen Pol Sumarto - Jl. HR Bunyamin - Jl. Ov. Isdiman - Jl. Jatiwinangun - Terminal Angkot - Jl. Kapten Piere Tendean - Jl. Perintis Kemerdekaan - Jl. Situmpur - Jl. S. Parman - Jl. Gerilya - Jl.Suwatio - Terminal Bus");
        MainModel angkot5 = new MainModel("Trayek C1", "Rute: Terminal Bus - Jl. Sultan Agung - Jl. Notoswiryo - Jl. DI. Panjaitan - Pasar Wage - Jl. Brigjen Katamso - Jl. Moch. Ikhsan - Terminal Angkot - Jl. Ov. Isdiman - Jl. Dr. Angka - Jl. Ahmad Yani - Jl. Jendral Gatot Subroto - Jl. Pemuda - Jl. Jendral Soedirman - Jl. Jendral Sutoyo - Jl. Pahlawan - Jl. Gerilya - Jl. Agus Salim - Jl. Mohammad Yamin - Jl. Lesan Pura - Perum Teluk - Jl. Sultan Agung - Jl. Notosuwiryo - Jl. Gerilya - Jl. Suwatio - Terminal Bus");
        MainModel angkot6 = new MainModel("Trayek C2", "Rute: Terminal Bus - Jl. Sultan Agung - Perum Teluk - Jl. Lesan Pura - Jl. Agus Salim - Jl. Gerilya - Jl. Pahlawan - Jl. Jendral Sutoyo - Jl. Jendral Soedirman - Jl. Pemuda - Jl. Jendral Gatot Subroto - Terminal Angkot - Jl. MT. Haryono - Pasar Wage - Jl. Jendral Soedirman - Jl. DI. Panjaitan - Jl. Gerilya - Jl. Suwatio - Terminal Bus");
        MainModel angkot7 = new MainModel("Trayek D1", "Rute: Terminal Bus - Jl. Sultan Agung - Jl. Notosuwiryo - Jl. DI. Panjaitan - Jl. Brigjen Katamso - Jl. KB. Suprapto - Jl. MT. Haryono - Jl. Jendral Soedirman - Jl. Supriyadi - Jl. Adipati Mersi - Jl. Panembahan Senopati - Jl. Martadireja - Jl. MT. Haryono - Jl. Moch. Ikhsan - Terminal Angkot - Jl. Adyaksa - Jl. Merdeka - Jl. Jendral Soedirman - Jl. Kolonel Sugiono - Jl. Kongsen - Jl. S. Parman - Jl. Gerilya - Jl. Suwatio - Terminal Bus");



        List<MainModel> angkotList = new ArrayList<>();

        angkotList.add(angkot1);
        angkotList.add(angkot2);
        angkotList.add(angkot3);
        angkotList.add(angkot4);
        angkotList.add(angkot5);
        angkotList.add(angkot6);
        angkotList.add(angkot7);


        return angkotList;
    }
}

