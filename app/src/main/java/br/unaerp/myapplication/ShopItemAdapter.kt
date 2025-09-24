package br.unaerp.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.unaerp.myapplication.databinding.ShopItemBinding

class ShopItemAdapter : RecyclerView.Adapter<ShopItemAdapter.ShopItemViewHolder>() {

    private val minhaLista = mutableListOf<ShopItem>()
    private var contadorCriado = 0
    private var contadorBind = 0

    inner class ShopItemViewHolder(val binding: ShopItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val binding = ShopItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShopItemViewHolder(binding)
    }

    override fun getItemCount(): Int = minhaLista.size

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        // incrementa quando o item é "bindado"
        contadorBind++
        val item = minhaLista[position].copy(idBind = contadorBind)

        holder.binding.tvIdCriado.text = "Criado: ${item.idCriado}"
        holder.binding.tvIdBind.text = "Bind: ${item.idBind}"
    }

    fun adicionarItem() {
        contadorCriado++
        val novoItem = ShopItem(idCriado = contadorCriado, idBind = 0)
        minhaLista.add(novoItem)
        notifyItemInserted(minhaLista.size - 1)
    }
}
