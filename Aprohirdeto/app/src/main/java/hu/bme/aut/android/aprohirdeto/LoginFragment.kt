package hu.bme.aut.android.aprohirdeto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hu.bme.aut.android.aprohirdeto.databinding.FragmentLoginBinding
import hu.bme.aut.android.aprohirdeto.databinding.FragmentProfileBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            if (binding.etEmailAddress.text.toString().isEmpty()) {
                binding.etEmailAddress.requestFocus()
                binding.etEmailAddress.error = "Írd be az e-mail címedet!"
            } else if (binding.etPassword.text.toString().isEmpty()) {
                binding.etPassword.requestFocus()
                binding.etPassword.error = "Add meg a jelszót!"
            } else {
                replaceFragment(HomepageFragment())
            }
        }

        binding.btnRegister.setOnClickListener {
            replaceFragment(RegisterFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_view, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
