package com.example.recyclernicovid_19.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclernicovid_19.R;
import com.example.recyclernicovid_19.modelo.Pais;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PaisesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaisesFragment extends Fragment {
    //AQUI SE PONEN LAS KEYS DE LAS VARAIBLES
    private static final  String PAIS = "pais";

    private static final String CODIGO = "codigo";

    private static String SLUG = "slug";

    private static String NUEVOS_CASOS = "nuevosCasos";

    private static String TOTAL_CASOS ="total casos";

    private static String NUEVAS_MUERTES = "nuevas muertes";

    private static String MUERTES_TOTAL= "muertes total";

    private static String NUEVOS_RECUPERADOS ="nuevos recuperados" ;

    protected static String TOTAL_RECUPERADOS = "total recuperados" ;

    protected static String FECHA = "fecha";
    //DESDE AQUI SE PONEN LAS VARIABLES

    private  String pais;
    private String codigo;
    private String slug;
    private int nuevosCasos;
    private int totalCasos;
    private int nuevasMuertes;
    private int muertesTotal;
    private int nuevosRecuperados;
    protected int totalRecuperados;
    protected String fecha;


    public PaisesFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PaisesFragment newInstance(String pais, String codigo, String slug, int nuevosCasos,
                                             int totalCasos, int nuevasMuertes, int muertesTotal, int nuevosRecuperados, int totalRecuperados, String fecha) {
        PaisesFragment fragment = new PaisesFragment();
        Bundle args = new Bundle();
        args.putString(PAIS, pais);
        args.putString(CODIGO, codigo);
        args.putString(SLUG, slug);
        args.putInt(NUEVOS_CASOS, nuevosCasos);
        args.putInt(TOTAL_CASOS, totalCasos);
        args.putInt(NUEVAS_MUERTES, nuevasMuertes );
        args.putInt(MUERTES_TOTAL, muertesTotal);
        args.putInt(NUEVOS_RECUPERADOS, nuevosRecuperados);
        args.putInt(TOTAL_RECUPERADOS, totalRecuperados);
        args.putString(FECHA, fecha);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
          pais = getArguments().getString(PAIS);
          codigo = getArguments().getString(CODIGO);
          slug = getArguments().getString(SLUG);
          nuevosCasos = getArguments().getInt(NUEVOS_CASOS);
          totalCasos = getArguments().getInt(TOTAL_CASOS);
          nuevasMuertes = getArguments().getInt(NUEVAS_MUERTES);
          muertesTotal = getArguments().getInt(MUERTES_TOTAL);
          nuevosRecuperados = getArguments().getInt(NUEVOS_RECUPERADOS);
          totalRecuperados = getArguments().getInt(TOTAL_RECUPERADOS);
          fecha = getArguments().getString(FECHA);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_paises, container, false);
    }
}
