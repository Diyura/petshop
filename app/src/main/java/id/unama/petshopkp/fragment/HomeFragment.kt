package id.unama.petshopkp.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import id.unama.petshopkp.*
import id.unama.petshopkp.adapter.ImageAdapter
import id.unama.petshopkp.databinding.ActivityChatBinding
import id.unama.petshopkp.databinding.FragmentHomeBinding
import id.unama.petshopkp.databinding.FragmentUserBinding
import id.unama.petshopkp.model.Image

class HomeFragment : Fragment() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private var _binding : FragmentHomeBinding? = null
    lateinit var auth : FirebaseAuth

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

        val imageList = listOf<Image>(
            Image(
                R.drawable.img1,
                "Image 1",
                "percobaan solution"
            ),
            Image(
                R.drawable.img2,
                "Image 2",
                "percobaan solution"
            ),
            Image(
                R.drawable.img3,
                "Image 3",
                "percobaan solution"
            ),
            Image(
                R.drawable.img4,
                "Image 4",
                "percobaan solution"
            ),
            Image(
                R.drawable.img5,
                "Image 5",
                "percobaan solution"
            )
        )

        val recyclerView: RecyclerView = view.findViewById(R.id._imageRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ImageAdapter(this, imageList){
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)

        binding.btnChat.setOnClickListener {
            btnChat()
        }
    }
}
    private fun btnChat() {
        val intent = Intent(context, ChatActivity::class.java)
        startActivity(intent)
    }

}





