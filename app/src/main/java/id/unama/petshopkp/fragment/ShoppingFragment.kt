package id.unama.petshopkp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import id.unama.petshopkp.R
import id.unama.petshopkp.adapter.ProdukAdapter
import id.unama.petshopkp.adapter.SliderAdapter
import id.unama.petshopkp.databinding.FragmentShoppingBinding
import id.unama.petshopkp.model.ModelProduk

class ShoppingFragment : Fragment() {

    private var binding : FragmentShoppingBinding? = null
    lateinit var vpSlider : ViewPager
    lateinit var rvObat : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_shopping, container, false)

        //slider
        vpSlider = view.findViewById(R.id.vp_slider)

        val arraySlider = ArrayList<Int>()

        arraySlider.add(R.drawable.obat_slider1)
        arraySlider.add(R.drawable.obat_slider2)
        arraySlider.add(R.drawable.obat_slider3)

        val sliderAdapter = SliderAdapter(arraySlider, activity)
        vpSlider.adapter = sliderAdapter

        //RecyclerView
        val lm = LinearLayoutManager(activity)
        lm.orientation = LinearLayoutManager.HORIZONTAL
        rvObat = view.findViewById(R.id.rv_obat)

        val adapterObat = ProdukAdapter(ArrayObat,activity)
        rvObat.setHasFixedSize(true)
        rvObat.layoutManager = lm
        rvObat.adapter = adapterObat

        return view
    }

    val ArrayObat : ArrayList<ModelProduk>get(){

        val arraybaju = ArrayList<ModelProduk>()

        //1
        val produkobat1 = ModelProduk()
        produkobat1.namaProduk = "Obat Catyzole"
        produkobat1.hargaProduk = "Rp. belum ada"
        produkobat1.gambarProduk = R.drawable.obat_1

        //2
        val produkobat2 = ModelProduk()
        produkobat2.namaProduk = "Obat Stop Dix"
        produkobat2.hargaProduk = "Rp. belum ada"
        produkobat2.gambarProduk = R.drawable.obat_2

        //3
        val produkobat3 = ModelProduk()
        produkobat3.namaProduk = "Obat Scadix"
        produkobat3.hargaProduk = "Rp. belum ada"
        produkobat3.gambarProduk = R.drawable.obat_3

        //4
        val produkobat4 = ModelProduk()
        produkobat4.namaProduk = "Obat Detick"
        produkobat4.hargaProduk = "Rp. belum ada"
        produkobat4.gambarProduk = R.drawable.obat_4

        //5
//        val produkbaju5 = ModelProduk()
//        produkbaju5.namaProduk = "Jaket Merah"
//        produkbaju5.hargaProduk = "Rp. 149.000"
//        produkbaju5.gambarProduk = R.drawable.jaket_1
//
//        //6
//        val produkbaju6 = ModelProduk()
//        produkbaju6.namaProduk = "Jaket Hitam"
//        produkbaju6.hargaProduk = "Rp. 149.000"
//        produkbaju6.gambarProduk = R.drawable.jaket_2

        arraybaju.add(produkobat1)
        arraybaju.add(produkobat2)
        arraybaju.add(produkobat3)
        arraybaju.add(produkobat4)
//        arraybaju.add(produkbaju5)
//        arraybaju.add(produkbaju6)

        return arraybaju
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}