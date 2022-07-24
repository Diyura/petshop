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
import id.unama.petshopkp.databinding.FragmentShoppingBinding
import id.unama.petshopkp.model.ModelProduk

class ShoppingFragment : Fragment() {

    private var binding : FragmentShoppingBinding? = null
    lateinit var rvObat : RecyclerView
    lateinit var rvPeralatan : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_shopping, container, false)

        //RecyclerView
        val lm = LinearLayoutManager(activity)
        lm.orientation = LinearLayoutManager.HORIZONTAL
        rvObat = view.findViewById(R.id.rv_obat)

        val adapterObat = ProdukAdapter(ArrayObat,activity)
        rvObat.setHasFixedSize(true)
        rvObat.layoutManager = lm
        rvObat.adapter = adapterObat

        val llm = LinearLayoutManager(activity)
        llm.orientation = LinearLayoutManager.HORIZONTAL
        rvPeralatan = view.findViewById(R.id.rv_vitamin)

        val adapterpr = ProdukAdapter(ArrayVitamin,activity)
        rvPeralatan.setHasFixedSize(true)
        rvPeralatan.layoutManager = llm
        rvPeralatan.adapter = adapterpr

        return view
    }

    val ArrayObat : ArrayList<ModelProduk>get(){

        val arrayEtalase = ArrayList<ModelProduk>()

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

        arrayEtalase.add(produkobat1)
        arrayEtalase.add(produkobat2)
        arrayEtalase.add(produkobat3)
        arrayEtalase.add(produkobat4)

        return arrayEtalase
    }

    val ArrayVitamin : ArrayList<ModelProduk>get(){

        val arrayEtalase = ArrayList<ModelProduk>()

        //1
        val produkvitamin1 = ModelProduk()
        produkvitamin1.namaProduk = "Obat Catyzole"
        produkvitamin1.hargaProduk = "Rp. belum ada"
        produkvitamin1.gambarProduk = R.drawable.obat_2

        //2
        val produkvitamin2 = ModelProduk()
        produkvitamin2.namaProduk = "Obat Stop Dix"
        produkvitamin2.hargaProduk = "Rp. belum ada"
        produkvitamin2.gambarProduk = R.drawable.obat_1

        //3
        val produkvitamin3 = ModelProduk()
        produkvitamin3.namaProduk = "Obat Scadix"
        produkvitamin3.hargaProduk = "Rp. belum ada"
        produkvitamin3.gambarProduk = R.drawable.obat_4

        //4
        val produkvitamin4 = ModelProduk()
        produkvitamin4.namaProduk = "Obat Detick"
        produkvitamin4.hargaProduk = "Rp. belum ada"
        produkvitamin4.gambarProduk = R.drawable.obat_3

        arrayEtalase.add(produkvitamin1)
        arrayEtalase.add(produkvitamin2)
        arrayEtalase.add(produkvitamin3)
        arrayEtalase.add(produkvitamin4)

        return arrayEtalase
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}