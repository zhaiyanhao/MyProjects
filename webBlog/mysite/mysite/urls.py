from django.conf.urls import patterns, include, url
from django.views.generic import TemplateView
from blog.views import Abouts
from django.contrib import admin
from django.conf import settings

admin.autodiscover()

urlpatterns = patterns('',
    # Examples:
    # url(r'^$', 'mysite.views.home', name='home'),
     url(r'^blog/', include('blog.urls')),
    url(r'^about/', Abouts),
    url(r'^$', TemplateView.as_view(template_name='index.html'), name="home"),
    url(r'^admin/', include(admin.site.urls)),

)

urlpatterns += patterns('',  
            (r'^static/(?P<path>.*)$', 'django.views.static.serve', {'document_root': settings.STATIC_PATH, 'show_indexes':True}),  
            ) 


urlpatterns += patterns('',  
            (r'^media/(?P<path>.*)$', 'django.views.static.serve',{'document_root': settings. MEDIA_ROOT }),

            ) 
