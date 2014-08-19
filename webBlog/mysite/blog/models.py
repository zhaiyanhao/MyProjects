from django.db import models
from django.contrib import admin
from ThumbnailImageField import ThumbnailImageField

# Create your models here.
class BlogPost(models.Model):
    title = models.CharField(max_length=150)
    body = models.TextField()
    timestamp= models.DateTimeField()
    class Meta:
        ordering = ('-timestamp',)

class BlogPostAdmin(admin.ModelAdmin):
    list_display= ('title','timestamp')


class Item(models.Model):
	name = models.CharField(max_length = 250)
	description = models.TextField()
	
	class Meta:
		ordering = ['name']

	def __unicode_(self):
		return self.name

	@models.permalink
	def get_absolute_url(self):
		return ( 'item_detail', None, {'object_id':self.id} )

class Photo(models.Model):
	item = models.ForeignKey(Item)
	title = models.CharField(max_length = 100)
	image = ThumbnailImageField(upload_to='photos')
	caption= models.CharField(max_length =250, blank = True)

	class Meta:
		ordering = ['title']

	def __unicode_(self):
		return self.name


	@models.permalink
	def get_absolute_url(self):
		return ( ' photo_detail', None, {'object_id':self.id} )

class PhotoInline(admin.StackedInline):
	model = Photo

class ItemAdmin(admin.ModelAdmin):
	inlines= [PhotoInline]
        list_display= ('name','description')

class PhotoAdmin(admin.ModelAdmin):
        list_display= ('title','caption')



admin.site.register(Item, ItemAdmin)
admin.site.register(Photo,PhotoAdmin)
admin.site.register(BlogPost,BlogPostAdmin)
