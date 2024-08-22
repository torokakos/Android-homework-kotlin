package hu.bme.aut.android.aprohirdeto

import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.android.aprohirdeto.databinding.FragmentHomepageBinding

class HomepageFragment: Fragment() {
    private lateinit var binding : FragmentHomepageBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomepageBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)


        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.buyButton.setOnClickListener{

        }
        binding.messageSellerButton.setOnClickListener{

        }
        binding.profileButton.setOnClickListener{
            replaceFragment(ProfileFragment())
        }



    }


    fun newMarketplaceItem() {
        // You can add static methods or properties here if needed
    }

    fun replaceFragment(fragment : Fragment){

        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_view, fragment)
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit()
    }


    companion object {
        const val TAG = "HomepageFragment"
    }

}