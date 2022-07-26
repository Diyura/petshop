package id.unama.petshopkp.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import id.unama.petshopkp.ChatActivity
import id.unama.petshopkp.DetailActivity
import id.unama.petshopkp.ListActivity
import id.unama.petshopkp.R
import id.unama.petshopkp.adapter.ImageAdapter
import id.unama.petshopkp.databinding.FragmentHomeBinding
import id.unama.petshopkp.model.Image

class HomeFragment : Fragment() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private var _binding: FragmentHomeBinding? = null
    lateinit var auth: FirebaseAuth

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        val imageList = listOf(
            Image(
                R.drawable.img1,
                "(solusi dari penyakit kucig)",
                "percobaan solution"
            ),
            Image(
                R.drawable.img2,
                "(solusi dari penyakit kucing)",
                "percobaan solution"
            ),
            Image(
                R.drawable.img3,
                "(solusi dari penyakit kucing)",
                "percobaan solution"
            ),
            Image(
                R.drawable.img4,
                "(solusi dari penyakit kucing)",
                "percobaan solution"
            ),
            Image(
                R.drawable.img5,
                "solusi dari penyakit kucing",
                "percobaan solution"
            )
        )

        val recyclerView: RecyclerView = view.findViewById(R.id._imageRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ImageAdapter(requireContext(), imageList) {
            val intent = Intent(requireContext(), DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)

            binding.btnChat.setOnClickListener {
                btnChat()
            }

            binding.btnList.setOnClickListener {
                btnList()
            }

        }

    }

    private fun btnList() {
        val intent = Intent(context, ListActivity::class.java)
        startActivity(intent)
    }

    private fun btnChat() {
        val intent = Intent(context, ChatActivity::class.java)
        startActivity(intent)
    }
}








