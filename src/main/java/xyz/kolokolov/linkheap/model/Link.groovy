package xyz.kolokolov.linkheap.model
/**
 * Основной объект ссылки
 */
class Link implements Serializable {

    Integer id

    String title

    String url

    String description

    //for serialization
    Link() {}

    Link(Integer id, title, url, description) {
        this.id = id
        this.title = title
        this.url = url
        this.description = description
    }
}
