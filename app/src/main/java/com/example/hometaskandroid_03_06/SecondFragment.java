package com.example.hometaskandroid_03_06;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.hometaskandroid_03_06.databinding.FragmentSecondBinding;
import java.util.ArrayList;

public class SecondFragment extends Fragment implements Hlick{
    public static String SONGS_NAME_KEY="name of a song";
    public ArrayList<Songs> list;
    private FragmentSecondBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentSecondBinding.inflate(LayoutInflater.from(
                requireContext()), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        RecyclerView recyclerView = binding.recyclerListOfSongs;
        Adaptor adaptor = new Adaptor(list, this);
        recyclerView.setAdapter(adaptor);
    }

    private void loadData() {
        list=new ArrayList<>();

        list.add(new Songs(1,"drivers license","Olivia Rodrigo", "4:02"));
        list.add(new Songs(2,"MONTERO", "Lil Nas X", "2:17"));
        list.add(new Songs(3,"STAY ", "Justin Bieber", "2:21"));
        list.add(new Songs(4,"good 4 u", "Olivia Rodrigo","2:58"));
        list.add(new Songs(5,"Olivia Rodrigo", "DaBaby", "3:23"));
        list.add(new Songs(6,"Peaches ", "Daniel Caesar", "3:18"));
        list.add(new Songs(7,"Kiss Me More", "Doja CatSZA", "3:28"));
        list.add(new Songs(8,"Blinding Lights", "The Weeknd","3:28"));
        list.add(new Songs(9,"Heat Waves", "Glass Animals","3:58"));
        list.add(new Songs(10,"Beggin'", "Måneskin", "3:31"));
    }

    @Override
    public void onHlick(Songs songs) {
        Toast.makeText(requireActivity(), "Hlick "+songs.getNameOfSong(),
                Toast.LENGTH_SHORT).show();

        Bundle bundle = new Bundle();
        Fragment fragment = new ThirdFragment();
        Fragment fragment1 = new ThirdFragment();
        Fragment fragment2 = new ThirdFragment();
        if (songs.getNameOfSong()!=null) {
            bundle.putString(SONGS_NAME_KEY, songs.getNameOfSong());
        }
        list=new ArrayList<>();
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame2, fragment1).commit();
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame1, fragment2).commit();
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment).commit();
    }
}