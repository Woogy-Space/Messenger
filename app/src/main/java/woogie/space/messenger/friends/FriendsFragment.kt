package woogie.space.messenger.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import woogie.space.messenger.MainViewModel
import woogie.space.messenger.R
import woogie.space.messenger.base.BaseMainFragment
import woogie.space.messenger.databinding.FragmentFriendsBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FriendsFragment : BaseMainFragment<FragmentFriendsBinding,MainViewModel>() {
    private var param1: String? = null
    private var param2: String? = null

    override val viewModel: MainViewModel by activityViewModels()

    override fun BindInit() {
        bind.apply {
            friends = viewModel
            lifecycleOwner = requireActivity()
            executePendingBindings()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = DataBindingUtil.inflate(inflater,R.layout.fragment_friends,container,false)
        BindInit()
        return bind.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FriendsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}