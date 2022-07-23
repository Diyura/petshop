package id.unama.petshopkp.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import id.unama.petshopkp.*
import id.unama.petshopkp.databinding.ActivityChatBinding
import id.unama.petshopkp.databinding.FragmentHomeBinding
import id.unama.petshopkp.databinding.FragmentUserBinding

class HomeFragment : Fragment() {

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

        binding.btnChat.setOnClickListener {
            btnChat()
        }
    }

    private fun btnChat() {
        val intent = Intent(context, ChatActivity::class.java)
        startActivity(intent)
    }
}