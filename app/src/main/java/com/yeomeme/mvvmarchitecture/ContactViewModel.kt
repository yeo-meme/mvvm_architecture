package com.yeomeme.mvvmarchitecture

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

/**

 * Created by yeomeme@gmail.com on 2021-04-02
 *
 */
class ContactViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ContactRepository(application)
    private val contacts = repository.getAll()

    fun getAll () : LiveData<List<Contact>> {
        return this.contacts
    }

    fun insert(contact: Contact) {
        repository.insert(contact)
    }

    fun delete(contact: Contact) {
        repository.delete(contact)
    }
}