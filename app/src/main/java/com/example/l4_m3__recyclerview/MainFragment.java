package com.example.l4_m3__recyclerview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.l4_m3__recyclerview.databinding.FragmentMainBinding;

import java.util.ArrayList;


public class MainFragment extends Fragment implements OnClick{
    private FragmentMainBinding binding;

 private ArrayList<CountryModel>countryList=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentMainBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       loadData();
        initAdapter();

    }

    private void loadData() {
        countryList.add(new CountryModel("data:image/png;base64,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","Kyrgyzstan","Bishkek"));
        countryList.add(new CountryModel("data:image/jpeg;base64,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","France","Paris"));
        countryList.add(new CountryModel("data:image/jpeg;base64,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","Balkaria","Nalchik"));
        countryList.add(new CountryModel("data:image/png;base64,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","Argentina","Buenos-Aires"));
        countryList.add(new CountryModel("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAARMAAAC3CAMAAAAGjUrGAAAAFVBMVEX///8AkkbOKzcAjz56uI/ehIjNHy1xf0V9AAAA/klEQVR4nO3QSQ0AIAADsHH6l4yKPUhaCc2oWTs9586aOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHy4ckD5KrN4eD2boIAAAAASUVORK5CYII=","Italy","Roma"));
        countryList.add(new CountryModel("","Korea","Seoul"));
        countryList.add(new CountryModel("","Russia","Moscow"));
        countryList.add(new CountryModel("","Spain","Madrid"));
        countryList.add(new CountryModel("","Kazakhstan","Astana"));
        countryList.add(new CountryModel("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAARMAAAC3CAMAAAAGjUrGAAAAflBMVEX///+8AC23AAC5ABa7ACq5ABu7ACi4ABC6AB+7ACfnu8G6ACS4ABS4ABX57e/DN023AAbtzNDpwsfSd4P9+frsyc7z3uHiqrL35+q/GjnjrbT78/XltbvQbnu9CjHx2NvFQVXXiJLAJD/JVGXdnaXZj5nMX27CMkrGRFjNZXM/4KopAAADXklEQVR4nO3diVbqMBCAYZNaUlqWsgkoAoLr+7/ghcvhKGZQuqQ5wf97gs6cdpJO0+TmBgAAAAAAAAAAAAAAAAAA7I1nq8EwXaTDwWo29n0x3o0H09F7onNjulEUdY3JdbIeTQd/NjOTpzdt4qytTrWz2Oi3p4nvy2te+pGbpKXOaSUmf019X2STViPTzc7m4yjrmtHK96U2ZNjXya8JOUh0/y/cLOncfK8gP2mb+bVnZbIx54uIrGU211xve1tdNCP/s6K3Pd+X7sqz/r2wyjL97Pvinej1OyUzstfpX+GtssiLlFZbO1/4DqFuI10pI3t65DuIWo3XceWUKBWvr+g9qLcsW1xPZcurKSqzuMwILGnFd76Dqcedua0pJUrdmqtISp0puZKk9KI6U7JLShR8TRmrumrJUUuFPvr06xlxvsr6voOq5rGOecl38aPvsKq4zx2kRKn83ndg5c2qT+hleuY7tNI2ddfXo9bGd2hlvUSOUqJU9OI7uHKcPTl7gT4962oNk5+1177DKyM1DlOilAmxna/qndN/d6t8B1jc1F2BPYimvkMsLHN7m+xulMx3iEXdu75NdjdKaLPZuavp2qfW3HeQxUzcDjoHJqxvpq/1twhs2avvMIt4cDmF/aQffAdawNRF28QWhzQcv7uc1n9qv/sO9HINPTpBPTwL95OTgyic7+qPTYw6e1k4nVnn8/qjcOb3MzedaUkeSmspbaqc7ApKKF2Ul0uXv1aXhNKX3TZVYndFdus72AstmyqxuyK79B3shZqase1p38FepsFhJ5iBZ9VE7+TIhPHnxrDK2uCiOkPf4V6ksbedvUDeeBpqnhwE0kIhJzZyYiMnNnJiY9yxMT+xMY+18b4j4L3YRv/ERp/NRj/WRt/exvcdAd8BbXwvtrGuwMb6EwHrlGysZ7Ox7lHA+lgb66gFrLe38V+GwP3/O23fIRbGf14C/ge0Of5vNA+lc3KC/4tt/IcuYL8CAfta2Nj/RMA+OQL2UxKw75aN/dkE7OMnYL9HAfuCCurcPzbgickp9hkWsB+1hH3LBexvL+AcBAnnZQg4V0XC+TsSzmmScJ6X5G5kOpz7ZrngfMCPv3KLfME5kiLOGz3ncC5tyrm0AAAAAAAAAAAAAAAAAAB88Q8Y1kd+iE5jqAAAAABJRU5ErkJggg==","Japan","Tokio"));
        countryList.add(new CountryModel("","Turkey","Ankara"));
        countryList.add(new CountryModel("","Mexico","Mexico"));
        countryList.add(new CountryModel("","Estonia","Tallinn"));
        countryList.add(new CountryModel("","Czech","Prague"));
        countryList.add(new CountryModel("","Iceland","Reykjavik"));


    }

    private void initAdapter() {
        CountryAdapter adapter=new CountryAdapter(countryList,this);
        binding.rvCountry.setAdapter(adapter);

    }

    @Override
    public void onClick(int position) {
        CountryModel country=countryList.get(position);
        Toast.makeText(requireContext(), country.getName(), Toast.LENGTH_SHORT).show();
    }
}